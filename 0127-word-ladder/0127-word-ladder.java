class Solution {
    class Pair {
        String word;
        int level;

        public Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord)) return 0;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            String word = queue.peek().word;
            int level = queue.peek().level;
            queue.poll();
            if (word.equals(endWord))
                return level;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char arr[] = word.toCharArray();
                    arr[i] = ch;
                    String modWrd = new String(arr);
                    if (set.contains(modWrd)) {
                        set.remove(modWrd);
                        queue.offer(new Pair(modWrd, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}