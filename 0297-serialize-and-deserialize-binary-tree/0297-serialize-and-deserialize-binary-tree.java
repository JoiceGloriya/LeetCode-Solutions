/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        sb.append(root.val + " ");

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();

                if (node.left == null) {
                    sb.append("# ");
                } else {
                    sb.append(node.left.val + " ");
                    queue.offer(node.left);  
                }

                if (node.right == null) {
                    sb.append("# ");
                } else {
                    sb.append(node.right.val + " ");
                    queue.offer(node.right);  
                }

            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "")
            return null;

        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode node = queue.poll();

            if (!values[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                queue.offer(left);
            }
            i++;
            if (!values[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));    //i has already been incremented
                node.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));