package leetcode.question0187;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution1 {

    @Test
    void test() {
        findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        int length = s.length();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            switch (s.charAt(i)) {
                case 'A': {
                    nums[i] = 0;
                    break;
                }
                case 'C': {
                    nums[i] = 1;
                    break;
                }
                case 'G': {
                    nums[i] = 2;
                    break;
                }
                case 'T': {
                    nums[i] = 3;
                    break;
                }
            }
        }

        int L = 10;
        int R = 4;
        int RL = pow(R, L - 1);

        HashSet<String> result = new HashSet<>();
        HashSet<Integer> repeatedHashVal = new HashSet<>();
        int left = 0;
        int right = 0;
        int slidingHashWindow = 0;
        while (right < nums.length) {
            slidingHashWindow = slidingHashWindow * R + nums[right];
            right++;

            if (right - left == L) {
                if (repeatedHashVal.contains(slidingHashWindow)) {
                    result.add(s.substring(left, right));
                } else {
                    repeatedHashVal.add(slidingHashWindow);
                }
                slidingHashWindow = slidingHashWindow - nums[left] * RL;
                left++;
            }
        }

        return new ArrayList<>(result);
    }

    private int pow(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }
}
