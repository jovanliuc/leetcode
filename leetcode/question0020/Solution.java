package leetcode.question0020;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Solution {

    @Test
    void test() {
        isValid("([]){");
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && getPair(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private char getPair(char c) {
        if (c == ')') {
            return '(';
        } else if (c == ']') {
            return '[';
        } else {
            return '{';
        }
    }
}
