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
class Solution { //recursive: O(N)
    public int maxDepth(TreeNode root) {
        // if (root == null)
        //     return 0;
        // int leftHeight = maxDepth(root.left);
        // int rightHeight = maxDepth(root.right);
        // return (1 + Math.max(leftHeight, rightHeight));

        //iterative: O(N)
        if (root == null)
            return 0;
        int ct = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            ct++;
            for(int i = 0; i < size; i ++) {
                TreeNode q = queue.poll();
                if(q.left != null) queue.offer(q.left);
                if(q.right != null) queue.offer(q.right);
            }
        }
return ct;
    }
}