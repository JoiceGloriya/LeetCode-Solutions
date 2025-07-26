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
class Solution {
    private int ct = 0;

    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        
        while (curr != null) {
            if (curr.left == null) {
                ct++;
                if (ct == k) {
                    return curr.val;
                }
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    ct++;
                    if (ct == k) {
                        return curr.val;
                    }
                    curr = curr.right;
                }
            }    
        }
        return -1;
    }
}