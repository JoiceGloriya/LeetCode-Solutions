class Solution {

    void dfs(int startNode, boolean[] vis, int[][] isConnected) {
        vis[startNode] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[startNode][i] == 1 && !vis[i]) {
                dfs(i, vis, isConnected);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int provinces = 0;

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                provinces++;
                dfs(i, vis, isConnected);
            }
        }
        return provinces;
    }
}