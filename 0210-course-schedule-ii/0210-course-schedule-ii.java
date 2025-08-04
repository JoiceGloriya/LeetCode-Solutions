class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int[] inorder = new int[numCourses];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(v).add(u);//reverse mapping as per prob description
        }

        for (int i = 0; i < numCourses; i++) {
            for (int j : adj.get(i))
                inorder[j]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (inorder[i] == 0)
                queue.offer(i);
        }
        
        
        while (!queue.isEmpty()) {
            int num = queue.poll();
            list.add(num);
           

            for (int j : adj.get(num)) {
                inorder[j]--;
                if (inorder[j] == 0)
                    queue.offer(j);
            }
        }
        if (list.size() != numCourses)   //means a cycle exists and no topological ordering exists and therefore it will be impossible to take all courses.
            return new int[] {};

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;

    }
}