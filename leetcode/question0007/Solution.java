package leetcode.question0007;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        int res = reverse(1463847412);
        System.out.println(res);
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int modRes = x % 10;
            if (res > 214748364 || (res == 214748364 && modRes > 7)) {
                return 0;
            }
            if (res < -214748364 || (res == -214748364 && modRes < -8)) {
                return 0;
            }
            res = res * 10 + modRes;
            x /= 10;
        }

        return res;
    }
}
