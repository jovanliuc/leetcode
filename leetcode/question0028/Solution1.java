package leetcode.question0028;

import org.junit.jupiter.api.Test;

public class Solution1 {

    int[][] dp;

    @Test
    void test() {
        int index = strStr("ababedababcdef", "ababc");
        System.out.println(index);
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0 || needle == null || needle.length() == 0) {
            return -1;
        }

        kmp(needle);

        int len = haystack.length();
        int j = 0;
        for (int i = 0; i < len; i++) {
            j = dp[j][haystack.charAt(i)];
            if (j == needle.length()) {
                return i - j + 1;
            }
        }

        return -1;
    }

    private void kmp(String pat) {
        int len = pat.length();
        dp = new int[len][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        int shadow = 0;
        for (int j = 1; j < len; j++) {
            for (int c = 0; c < 256; c++) {
                if (pat.charAt(j) == c) {
                    dp[j][c] = j + 1;
                } else {
                    dp[j][c] = dp[shadow][c];
                }
            }
            shadow = dp[shadow][pat.charAt(j)];
        }
    }
}
