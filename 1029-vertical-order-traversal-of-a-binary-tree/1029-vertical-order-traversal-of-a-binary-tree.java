/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    class Triplet {
        TreeNode node = new TreeNode();
        int vertical, level;

        public Triplet(TreeNode node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }
class Solution {


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Triplet> queue = new LinkedList<>();
        queue.offer(new Triplet(root, 0, 0));
        
        while(!queue.isEmpty()) {
            Triplet triplet = queue.poll();
            TreeNode node = triplet.node;
            int x = triplet.vertical;
            int y = triplet.level;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<Integer>() );
            map.get(x).get(y).offer(node.val);

            if(node.left != null)
                queue.offer(new Triplet(node.left, x - 1, y + 1));
            if(node.right != null)
                queue.offer(new Triplet(node.right, x + 1, y + 1));    
        }

        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> mpp : map.values()) {
            List<Integer> ans = new ArrayList<>();
            for(PriorityQueue<Integer> pq: mpp.values()) {
                while(!pq.isEmpty())
                    ans.add(pq.poll());
            }
           list.add(ans); 
        }
        return list;
    }
}