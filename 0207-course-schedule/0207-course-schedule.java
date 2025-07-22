class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int edge[] : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int j : adj.get(i)) {
                indegree[j]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i < numCourses; i ++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int ct = 0;
        while(!queue.isEmpty()) {
            ct++;
            int num = queue.poll();
            
            for (int i : adj.get(num)) {
                indegree[i]--;
                if(indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        return numCourses == ct;
    }
}