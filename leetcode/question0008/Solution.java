package leetcode.question0008;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        int res = myAtoi("123dsads");
        System.out.println(res);
    }

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int len = str.length();
        int res = 0;
        int index = 0;
        boolean isNegative = false;
        while (index < len && str.charAt(index) == ' ') {
            index++;
        }
        if (index == len) {
            return 0;
        }
        if (str.charAt(index) == '-') {
            isNegative = true;
        }
        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            index++;
        }
        while (index < len && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            int curVal = str.charAt(index) - 48;
            if (!isNegative && (res > 214748364 || (res == 214748364 && curVal > 7))) {
                return 2147483647;
            }
            if (isNegative && (-res < -214748364 || (-res == -214748364 && -curVal < -8))) {
                return -2147483648;
            }
            res = res * 10 + curVal;
            index++;
        }
        if (isNegative) {
            res = -res;
        }

        return res;
    }
}
