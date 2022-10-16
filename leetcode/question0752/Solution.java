package leetcode.question0752;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    @Test
    void test() {
        String[] deadends = new String[]{"0000"};
        String target = "8888";
        openLock(deadends, target);
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }

        Queue<String> queue = new LinkedList<>();
        int step = 0;
        queue.offer("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                String s = queue.poll();
                if (deads.contains(s)) {
                    continue;
                }

                if (s.equals(target)) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {

                    String plusOne = plusOne(s, j);
                    if (!visited.contains(plusOne)) {
                        queue.offer(plusOne);
                        visited.add(plusOne);
                    }

                    String minusOne = minusOne(s, j);
                        if (!visited.contains(minusOne)) {
                            queue.offer(minusOne);
                            visited.add(minusOne);
                        }
                    }
                }

            step++;
        }

        return -1;
    }

    private String plusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j] += 1;
        }
        return new String(chars);
    }

    private String minusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j] -= 1;
        }
        return new String(chars);
    }
}
