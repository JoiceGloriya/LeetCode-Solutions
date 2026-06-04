class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1; i <= numRows; i ++) 
            ans.add(generateRow(i));

        return ans;
    } 

    List<Integer> generateRow (int numRow) {
        int ans = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1); // 1element is added here

        for(int i = 1; i < numRow; i ++) { // r-1 elements added here
            ans = ans * (numRow - i);
            ans = ans / i;
            list.add(ans);
        }

        return list;
    }
}