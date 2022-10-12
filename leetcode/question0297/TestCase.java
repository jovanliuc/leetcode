package leetcode.question0297;

import org.junit.jupiter.api.Test;

public class TestCase {

    @Test
    void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Codec codec = new Codec();
        String serializedTreeString = codec.serialize(root);
        codec.deserialize(serializedTreeString);
    }
}
