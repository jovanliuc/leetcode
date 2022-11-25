package leetcode.question0225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> queue;
    private int valOfTopOfStack;

    public MyStack() {
        queue = new LinkedList<>();
        valOfTopOfStack = -1;
    }

    public void push(int x) {
        queue.offer(x);
        valOfTopOfStack = x;
    }

    public int pop() {
        int size = queue.size();
        while (size > 2) {
            queue.offer(queue.poll());
            size--;
        }
        valOfTopOfStack = queue.peek();
        queue.offer(queue.poll());
        return queue.poll();
    }

    public int top() {
        return valOfTopOfStack;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
