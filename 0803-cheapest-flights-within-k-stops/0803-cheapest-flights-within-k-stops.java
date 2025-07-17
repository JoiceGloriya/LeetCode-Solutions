class Solution {
    class Tuple {
        int stops, node, dis;

        public Tuple(int stops, int node, int dis) {
            this.stops = stops;
            this.node = node;
            this.dis = dis;
        }
    }

    class Pair {
        int node, wt;

        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        int[] distance = new int[n];
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(0, src, 0));
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            int source = flight[0];
            int dest = flight[1];
            int stop = flight[2];
            
            adj.get(source).add(new Pair(dest, stop));
        }

        while (!queue.isEmpty()) {
            int stops = queue.peek().stops;
            int node = queue.peek().node;
            int dis = queue.peek().dis;
            queue.poll();

            if (stops > k )
                continue;

            for (Pair pair : adj.get(node)) {
                int node1 = pair.node;
                int wt1 = pair.wt;
                if (dis + wt1 < distance[node1] && stops <= k) {
                    distance[node1] = dis + wt1;
                    queue.offer(new Tuple(stops + 1, node1, distance[node1]));
                }
            }
        }
        
        if (distance[dst] != Integer.MAX_VALUE)
            return distance[dst];
        return -1;

    }
}