package leetcode.question0150;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Solution {

    @Test
    void test() {
        String[]  tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int res = evalRPN(tokens);
        System.out.println(res);
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<Integer> result = new Stack<>();
        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                result.push(Integer.parseInt(token)) ;
            } else {
                if (!result.isEmpty()) {
                    int y = result.pop();
                    int x = result.pop();
                    if (token.equals("+")) {
                        result.push(x + y);
                    }
                    if (token.equals("-")) {
                        result.push(x - y);
                    }
                    if (token.equals("*")) {
                        result.push(x * y);
                    }
                    if (token.equals("/")) {
                        result.push(x / y);
                    }
                } else {
                    return 0;
                }
            }
        }

        return result.pop();
    }
}
