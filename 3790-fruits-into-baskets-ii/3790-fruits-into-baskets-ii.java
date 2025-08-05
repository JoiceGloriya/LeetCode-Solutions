class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                if(fruits[i] > baskets[j]) continue;
                else if(!mpp.containsKey(j)) {
                    mpp.put(j, fruits[i]);
                    break;
                }
                else continue;
            }
        }
        return n - mpp.size();
    }
}