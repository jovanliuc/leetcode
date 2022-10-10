package leetcode.question0187;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    @Test
    void test() {
        findRepeatedDnaSequences("AAAAAAAAAAAAA");
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        Set<String> repeatedStrSet = new HashSet<>();
        Set<String> resultSet = new HashSet<>();
        // Left is opening, and the right is closed
        for (int i = 0; i + 10 <= s.length(); i++) {

            String subStr = s.substring(i, i + 10);
            if (repeatedStrSet.contains(subStr)) {
                resultSet.add(subStr);
            } else {
                repeatedStrSet.add(subStr);
            }
        }

        return new ArrayList<>(resultSet);
    }
}
