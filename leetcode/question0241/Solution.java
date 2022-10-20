package leetcode.question0241;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    HashMap<String, List<Integer>> memo = new HashMap<>();

    @Test
    void test() {
        diffWaysToCompute("2*3-4*5");
    }

    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();
        if (expression == null || expression.length() == 0) {
            return result;
        }

        int len = expression.length();
        for (int i = 0; i < len; i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> leftResult = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightResult = diffWaysToCompute(expression.substring(i + 1));

                for (int a : leftResult) {
                    for (int b : rightResult) {
                        if (ch == '+') {
                            result.add(a + b);
                        }
                        if (ch == '-') {
                            result.add(a - b);
                        }
                        if (ch == '*') {
                            result.add(a * b);
                        }
                    }
                }
            }
        }

        // base case
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        memo.put(expression, result);
        return result;
    }
}
