package leetcode.question0337;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Solution {

    private HashMap<TreeNode, Integer> memo = new HashMap<>();

    @Test
    void test() {
        rob(null);
    }

    public int rob(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int maxAmountIfBob = root.val +
                (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) +
                (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int maxAmountIfNotRob = rob(root.left) + rob(root.right);
        int result = Math.max(maxAmountIfBob, maxAmountIfNotRob);
        memo.put(root, result);

        return result;
    }
}
