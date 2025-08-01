class Solution {

    private List<Integer> generateRow(int row) {
        int ans = 1;
        List<Integer> rowList = new ArrayList<>();
        rowList.add(ans);
        for(int i = 1; i < row; i ++) {
            ans = ans * (row - i);
            ans = ans / i;
            rowList.add(ans);
        }
        return rowList;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for(int i = 1; i <= numRows; i ++)
        pascalTriangle.add(generateRow(i));

        return pascalTriangle;
        
    }

}