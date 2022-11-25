package leetcode.question0232;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {

        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        int v1 = myQueue.peek(); // return 1
        int v2 = myQueue.pop(); // return 1, queue is [2]
        boolean v3 = myQueue.empty(); // return false
    }
}
