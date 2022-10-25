package leetcode.question1541;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        minInsertions(")(())(");
    }

    public int minInsertions(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int result = 0;
        int needRightBrackets = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                needRightBrackets += 2;
                if (needRightBrackets % 2 == 1) {
                    result++;
                    needRightBrackets--;
                }
            } else if (c == ')') {
                needRightBrackets--;
                if (needRightBrackets == -1) {
                    result++;
                    needRightBrackets = 1;
                }
            }
        }

        return result + needRightBrackets;
    }
}
