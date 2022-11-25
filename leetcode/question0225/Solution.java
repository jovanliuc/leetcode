package leetcode.question0225;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        int v1 = myStack.top(); // 返回 6
        int v2 = myStack.pop(); // 返回 6
        boolean v3 = myStack.empty(); // 返回 False
    }
}
