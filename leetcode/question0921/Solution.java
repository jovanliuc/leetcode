package leetcode.question0921;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        minAddToMakeValid("()))((");
    }

    public int minAddToMakeValid(String s) {
        int result = 0;
        int needRightBrackets = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                needRightBrackets++;
            } else if (c == ')') {
                needRightBrackets--;
                if (needRightBrackets == -1) {
                    result++;
                    needRightBrackets = 0;
                }
            }
        }

        return result + needRightBrackets;
    }
}
