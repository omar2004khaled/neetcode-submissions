public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        return root.val + "," 
                + serialize(root.left) + "," 
                + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] index = {0};

        return buildTree(values, index);
    }

    private TreeNode buildTree(String[] values, int[] index) {
        if (values[index[0]].equals("null")) {
            index[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(values[index[0]]));
        index[0]++;

        root.left = buildTree(values, index);
        root.right = buildTree(values, index);

        return root;
    }
}