package leetcode.question0116;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        connect(root);
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        traverse(root.left, root.right);
        return root;
    }

    private void traverse(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return;
        }

        node1.next = node2;

        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        traverse(node1.right, node2.left);
    }
}
