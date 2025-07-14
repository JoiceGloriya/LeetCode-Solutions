class Solution {

    void dfs(int startNode, boolean[] visited, List<List<Integer>> list) {
        visited[startNode] = true;

        // for(int i = 0; i < isConnected.length; i ++) {
        //     if(isConnected[startNode][i] == 1 && !visited[i])
        //         dfs(i, visited, isConnected);
        // }

        for (int i : list.get(startNode)) {
            if (!visited[i]) {
                dfs(i, visited, list);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        // for(int i = 0; i < n; i ++) {
        //     if(!visited[i]) {
        //         provinces++;
        //         dfs(i, visited, isConnected);
        //     }
        // }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 )
                    list.get(i).add(j);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(i, visited, list);
            }
        }

        return provinces;

    }
}