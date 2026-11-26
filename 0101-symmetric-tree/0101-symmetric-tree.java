class Solution {
    public boolean isSymmetric(TreeNode root) {
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        return compute(leftNode, rightNode);
    }

    boolean compute(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null)
            return true;
        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val)
            return false;
            
        return  compute(leftNode.left, rightNode.right)
                && compute(leftNode.right, rightNode.left);
    }
}