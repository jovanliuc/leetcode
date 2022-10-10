package leetcode.question0567;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    @Test
    void test() {
        checkInclusion("hello", "ooolleoooleh");
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return false;
        }

        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            target.put(s1.charAt(i), target.getOrDefault(s1.charAt(i), 0) + 1);
        }

        Map<Character, Integer> slidingWindow = new HashMap<>();
        int left = 0;
        int right = 0;
        int validCharCount = 0;
        while (right < s2.length()) {

            char rc = s2.charAt(right);
            right++;

            if (target.containsKey(rc)) {
                slidingWindow.put(rc, slidingWindow.getOrDefault(rc, 0) + 1);
                if (slidingWindow.get(rc).equals(target.get(rc))) {
                    validCharCount++;
                }
            }

            if (right - left >= s1.length()) {
                if (validCharCount == target.size()) {
                    return true;
                }

                char lc = s2.charAt(left);
                left++;

                if (target.containsKey(lc)) {
                    if (slidingWindow.get(lc).equals(target.get(lc))) {
                        validCharCount--;
                    }
                    slidingWindow.put(lc, slidingWindow.getOrDefault(lc, 0) - 1);
                }
            }
        }

        return false;
    }
}
