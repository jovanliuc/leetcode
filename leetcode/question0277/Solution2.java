package leetcode.question0277;

import org.junit.jupiter.api.Test;

public class Solution2 extends Relation {

    @Test
    void test() {
        findCelebrity(3);
    }

    public int findCelebrity(int n) {
        if (n == 1) {
            return 0;
        }

        int candidate = 0;
        for (int otherPerson = 1; otherPerson < n; otherPerson++) {
            if (knows(candidate, otherPerson) || !knows(otherPerson, candidate)) {
                candidate = otherPerson;
            }
        }

        for (int otherPerson = 0; otherPerson < n; otherPerson++) {
            if (candidate == otherPerson) {
                continue;
            }
            if (knows(candidate, otherPerson) || !knows(otherPerson, candidate)) {
                return -1;
            }
        }

        return candidate;
    }
}
