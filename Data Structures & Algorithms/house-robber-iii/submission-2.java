
class Solution {

    HashMap<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {

        if (root == null)
            return 0;

        // Already calculated?
        if (map.containsKey(root))
            return map.get(root);

        // Case 1: Don't rob this node
        int dontRob = rob(root.left) + rob(root.right);

        // Case 2: Rob this node
        int robRoot = root.val;

        if (root.left != null) {
            robRoot += rob(root.left.left);
            robRoot += rob(root.left.right);
        }

        if (root.right != null) {
            robRoot += rob(root.right.left);
            robRoot += rob(root.right.right);
        }

        int answer = Math.max(dontRob, robRoot);

        // Save answer
        map.put(root, answer);

        return answer;
    }
}