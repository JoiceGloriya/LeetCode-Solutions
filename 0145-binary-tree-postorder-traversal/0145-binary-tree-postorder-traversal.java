class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        Stack<TreeNode> stk = new Stack<>();
        List<Integer> list = new ArrayList<>();

        // Start from the root
        TreeNode curr = root;

        // Continue until there is no node left to process
        // and no node waiting in the stack.
        while (curr != null || !stk.isEmpty()) {

            // If we still have a current node,
            // keep going LEFT exactly like recursive postorder.
            if (curr != null) {

                while (curr != null) {

                    // Push the node because we're NOT allowed
                    // to print it yet.
                    // Its right subtree may still be pending.
                    stk.push(curr);

                    // Keep travelling to the extreme left.
                    curr = curr.left;
                }

            } else {

                // We've reached the end of a left path.
                // Now ask the top node:
                //
                // "Is your RIGHT subtree still waiting?"
                TreeNode temp = stk.peek().right;

                // No right child exists.
                // So:
                // Left subtree ✔
                // Right subtree ✔ (doesn't exist)
                // Safe to print this node.
                if (temp == null) {

                    temp = stk.pop();
                    list.add(temp.val);

                    // Maybe printing this node has also completed
                    // its parent's RIGHT subtree.
                    //
                    // Keep climbing upwards while that is true.
                    while (!stk.isEmpty() &&
                            temp == stk.peek().right) {

                        temp = stk.pop();
                        list.add(temp.val);
                    }

                } else {

                    // Right subtree still exists.
                    // Cannot print the current node yet.
                    //
                    // Go process the RIGHT subtree first.
                    curr = temp;
                }
            }
        }

        return list;
    }
}