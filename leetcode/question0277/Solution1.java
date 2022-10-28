package leetcode.question0277;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class Solution1 extends Relation {

    @Test
    void test() {
        findCelebrity(3);
    }

    public int findCelebrity(int n) {
        if (n == 1) {
            return 0;
        }

        LinkedList<Integer> persons = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            persons.addLast(i);
        }

        while (persons.size() >= 2) {
            int candidate = persons.removeFirst();
            int otherPerson = persons.removeFirst();
            if (knows(candidate, otherPerson) || !knows(otherPerson, candidate)) {
                persons.addLast(otherPerson);
            } else {
                persons.addLast(candidate);
            }
        }

        int candidate = persons.removeFirst();
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
