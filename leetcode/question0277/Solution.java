package leetcode.question0277;

import org.junit.jupiter.api.Test;

public class Solution extends Relation {

    @Test
    void test() {
        findCelebrity(3);
    }

    public int findCelebrity(int n) {
        for (int candidate = 0; candidate < n; candidate++) {
            int otherPerson = 0;
            for (; otherPerson < n; otherPerson++) {
                if (candidate == otherPerson) {
                    continue;
                }
                if (knows(candidate, otherPerson) || !knows(otherPerson, candidate)) {
                    break;
                }
            }
            if (otherPerson == n) {
                return candidate;
            }
        }

        return -1;
    }
}
