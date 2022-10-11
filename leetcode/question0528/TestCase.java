package leetcode.question0528;

import org.junit.jupiter.api.Test;

public class TestCase {

    @Test
    void test() {
        int[] w = {1, 3, 2, 1};
        Solution solution = new Solution(w);
        for (int i = 0; i < w.length; i++) {
            solution.pickIndex();
        }

    }
}
