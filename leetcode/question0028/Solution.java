package leetcode.question0028;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        int index = strStr("mississippi", "issip");
        System.out.println(index);
    }

    public int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        int i = 0;
        int j = 0;
        while (i < haystackLen && j < needleLen) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                i = i - j + 1;
                j = 0;
            } else {
                i++;
                j++;
            }
        }

        if (j == needleLen) {
            return i - j;
        } else {
            return -1;
        }
    }
}
