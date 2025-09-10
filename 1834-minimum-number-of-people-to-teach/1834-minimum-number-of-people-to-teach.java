class Solution {
  public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

    
    Map<Integer,Set<Integer>> ul = new HashMap<>();
    for(int i=0; i<languages.length; i++) {
      Set<Integer> lang = new HashSet<>();
      ul.put(i+1, lang);
      for(int l : languages[i]) {
        lang.add(l);
      }
    }

    // if two users are friends and they can' t speak to each other due to language issue, record it
    Map<Integer,Set<Integer>> uf = new HashMap<>();
    for(int i=0; i<friendships.length; i++) {
      int[] frnd = friendships[i];
      boolean canSpk = false;
      for(int l : ul.get(frnd[0])) {
        if(ul.get(frnd[1]).contains(l)) {
          canSpk = true;
          break;
        }
      }
      if(canSpk) continue;
      
      uf.putIfAbsent(frnd[0],new HashSet<>());
      uf.putIfAbsent(frnd[1],new HashSet<>());
      uf.get(frnd[0]).add(frnd[1]);
      uf.get(frnd[1]).add(frnd[0]);
    }
    
    int ans = Integer.MAX_VALUE;
    // for every language, see how many users need to learn it
    for(int i=1; i<=n; i++) {
      int tot = 0;
    // if we have to teach language i, then how many users need to learn this?
      for(int key : uf.keySet()) {
        if(!ul.get(key).contains(i)) tot++;
      }
      // if this language needs to be learned by less number of people, then this is the answer, else don't override the ans
      ans = Math.min(ans, tot);
    }
    
    return ans;
  }
}
