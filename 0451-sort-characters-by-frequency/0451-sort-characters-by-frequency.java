class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        Map<Character, Integer> mpp = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++)
            mpp.put(s.charAt(i), mpp.getOrDefault(s.charAt(i), 0) + 1);

        // PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
        //         (a, b) -> b.getValue() - a.getValue());

        // for (Map.Entry<Character, Integer> entry : mpp.entrySet()) {
        //     pq.offer(entry);
        // }

        // while (!pq.isEmpty()) {
        //     Map.Entry obj = pq.poll();
        //     char c = obj.getKey();
        //     int freq = obj.getValue();
        //     for (int i = 0; i < freq; i++) {
        //         sb.append(c);
        //     }
        // }
        // return sb.toString();

        
        ArrayList<Character>[] buckets = new ArrayList[n + 1];
          //populating buckets[]
        for (Map.Entry<Character, Integer> obj : mpp.entrySet()) {
            char c = obj.getKey();
            int freq = obj.getValue();
            if (buckets[freq] == null)
                buckets[freq] = new ArrayList<>();
            buckets[freq].add(c);
        }

        for (int i = n; i >= 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++)
                        sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}