package leetcode.question0151;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        reverseWords("the sky is blue");
    }

    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                stringBuilder.append(c);
            } else {
                if (!stringBuilder.isEmpty() && stringBuilder.charAt(stringBuilder.length() - 1) != ' ') {
                    stringBuilder.append(' ');
                }
            }
        }

        if (stringBuilder.charAt(stringBuilder.length() - 1) == ' ') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        char[] charArr = stringBuilder.toString().toCharArray();
        int length = charArr.length;
        reverse(charArr, 0, length - 1);
        for (int i = 0; i < length;) {
            for (int j = i; j < length; j++) {
                if (j + 1 == length || charArr[j + 1] == ' ') {
                    reverse(charArr, i, j);
                    i = j + 2;
                    break;
                }
            }
        }

        return new String(charArr);
    }

    private void reverse(char[] charArr, int left, int right) {
        while (left < right) {
            char c = charArr[left];
            charArr[left++] = charArr[right];
            charArr[right--] = c;
        }
    }
}
