class Solution {
    public int totalFruit(int[] fruits) {

        
//        // Brute-Force: but u'll get TLE error, T.C : O(N*N) and S.C : O(3).
//         int maxlen = 0;
// for(int i = 0; i < fruits.length; i ++) {
//     Set<Integer> obj = new HashSet<>();
//     for(int j = i; j < fruits.length; j ++) {
//         obj.add(fruits[j]);
//         if(obj.size() <= 2)
//         maxlen = Math.max(maxlen, j - i + 1);
//         else break;
//     }
// }
// return maxlen;

//Better and Optimal Approach : 
//T.C : O(N) The inner while loop shrinks the window, but across the entire execution of the outer loop, each element is added and removed from the obj map at most once. Thus, the inner loop contributes O(n) as well.


// The inner loop moves the l (left) pointer whenever there are more than 2 types of fruits in the window.
// However, each element is added and removed from the map at most once across the entire execution because:
// You only move the l pointer forward when the window has more than 2 types of fruits.
// Each time you move l, one fruit is removed or reduced from the map.
// This means that while the inner loop runs multiple times, overall it only processes each element once. So, across the entire array, the inner loop contributes O(n) time in total
//Since both the outer and inner loops together run in O(n), the total time complexity is O(n).


// and S.C :  O(1) The obj HashMap will store at most 2 different fruit types at any given time, so the space required by the map is constant.
     int maxlen = 0, l =  0, r = 0;
      Map<Integer, Integer> obj = new HashMap<>();
     while(r < fruits.length) {
       obj.put(fruits[r], obj.getOrDefault(fruits[r], 0) + 1);
       if(obj.size() > 2) {
          obj.put(fruits[l], obj.getOrDefault(fruits[l], 0) - 1);
          if(obj.get(fruits[l]) == 0) obj.remove(fruits[l]);
          l++;
       } 
       maxlen = Math.max(maxlen, (r - l + 1));
       r ++;
     }
     return maxlen;
    }
}