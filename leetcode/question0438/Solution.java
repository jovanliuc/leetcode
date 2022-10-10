package leetcode.question0438;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    @Test
    void test() {
        findAnagrams("cbaebabacd", "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 ) {
            return result;
        }

        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            target.put(p.charAt(i), target.getOrDefault(p.charAt(i), 0) + 1);
        }

        Map<Character, Integer> slidingWindow = new HashMap<>();
        int left = 0;
        int right = 0;
        int validCharCount = 0;
        while (right < s.length()) {
            char rc = s.charAt(right);
            right++;

            if (target.containsKey(rc)) {
                slidingWindow.put(rc, slidingWindow.getOrDefault(rc, 0) + 1);
                if (slidingWindow.get(rc).equals(target.get(rc))) {
                    validCharCount++;
                }
            }

            if (right - left >= p.length()) {
                if (validCharCount == target.size()) {
                    result.add(left);
                }

                char lc = s.charAt(left);
                left++;

                if (target.containsKey(lc)) {
                    if (slidingWindow.get(lc).equals(target.get(lc))) {
                        validCharCount--;
                    }
                    slidingWindow.put(lc, slidingWindow.get(lc) - 1);
                }
            }
        }

        return result;
    }
}
