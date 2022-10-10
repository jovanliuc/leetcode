package leetcode.question0003;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    @Test
    void test() {
        lengthOfLongestSubstring("abccdefg");
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> slidingWindow = new HashMap<>();
        int left =  0;
        int right  = 0;
        int maxLength = 0;
        while (right < s.length()) {

            char rc = s.charAt(right);
            right++;
            slidingWindow.put(rc, slidingWindow.getOrDefault(rc, 0) + 1);

            while (slidingWindow.get(rc) > 1) {
                char lc = s.charAt(left);
                left++;
                slidingWindow.put(lc, slidingWindow.get(lc) - 1);
            }

            if (right - left > maxLength) {
                maxLength = right - left;
            }
        }

        return maxLength;
    }
}
