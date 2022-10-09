package leetcode.question0076;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    @Test
    void test() {
        minWindow("ADOBECODEBANC", "ABC");
    }

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return null;
        }

        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        }

        Map<Character, Integer> slidingWindow = new HashMap<>();
        int validCharCount = 0;
        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minLength = Integer.MAX_VALUE;
        while (right < s.length()) {

            char rc = s.charAt(right);
            right++;

            slidingWindow.put(rc, slidingWindow.getOrDefault(rc, 0) + 1);
            if (slidingWindow.get(rc).equals(target.get(rc))) {
                validCharCount++;
            }

            while (validCharCount == target.size()) {

                if (right - left < minLength) {
                    minLength = right - left;
                    minLeft = left;
                }

                char lc = s.charAt(left);
                if (slidingWindow.get(lc).equals(target.get(lc))) {
                    validCharCount--;
                }
                slidingWindow.put(lc, slidingWindow.get(lc) - 1);
                left++;
            }
        }

        return minLength >= s.length() + 1 ? "" : s.substring(minLeft, minLeft + minLength);
    }
}
