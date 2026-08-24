class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            // Go as far left as possible
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // Visit the smallest remaining node
            root = stack.pop();
            k--;

            // k-th smallest found
            if (k == 0) {
                return root.val;
            }

            // Move to right subtree
            root = root.right;
        }
    }
}