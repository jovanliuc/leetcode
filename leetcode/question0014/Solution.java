package leetcode.question0014;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        String[] strs = {"flower","flow","flight"};
        longestCommonPrefix(strs);
    }

    public String longestCommonPrefix(String[] strs) {
        int rowLen = strs.length;
        int colLen = strs[0].length();

        for (int col = 0; col < colLen; col++) {
            for (int row = 1; row < rowLen; row++) {
                String curStr = strs[row];
                String preStr = strs[row - 1];
                if (col >= curStr.length() || col >= preStr.length() ||
                        curStr.charAt(col) != preStr.charAt(col)) {
                    return strs[row].substring(0, col);
                }
            }
        }

        return strs[0];
    }
}
