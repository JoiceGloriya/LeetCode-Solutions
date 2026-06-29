class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(int ind, int k, int n, List<Integer> list, List<List<Integer>> ans) {
        if (k == list.size() && n == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (k == list.size())
            return;

        for (int i = ind; i <= 9; i++) {
            if (n - i >= 0) {
                list.add(i);
                backtrack(i + 1, k, n - i, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }
}
