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
    TreeNode first = null, prev = null, second = null;
    void inorder(TreeNode root) {
        TreeNode cur = root;
        while(cur != null) {
        if(cur.left == null) {
            if(prev != null && prev.val > cur.val) {
                if(first == null)
                    first = prev;
                second = cur; 
            }
           prev =cur;
            cur = cur.right;
        }
            else {
                TreeNode temp = cur.left;
                while(temp.right != null && temp.right != cur)
                    temp = temp.right;
                if(temp.right == null) {
                    temp.right = cur;
                    cur = cur.left;
                }
                else {
                    temp.right = null;
                    if(prev != null && prev.val > cur.val) {
                if(first == null)
                    first = prev;
                second = cur; 
            }
           prev =cur;
                    cur = cur.right;
                }
                
            }
        
        }
    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}