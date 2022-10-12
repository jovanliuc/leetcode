package leetcode.question0297;

import java.util.LinkedList;

public class Codec {

    private static final String SEPARATOR_COMMA = ",";
    private static final String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        return serialize(root, stringBuilder).toString();
    }

    private StringBuilder serialize(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            return stringBuilder.append(NULL).append(SEPARATOR_COMMA);
        }

        stringBuilder.append(root.val).append(SEPARATOR_COMMA);

        stringBuilder = serialize(root.left, stringBuilder);
        stringBuilder = serialize(root.right, stringBuilder);

        return stringBuilder;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEPARATOR_COMMA)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }
}
