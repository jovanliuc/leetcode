package leetcode.question0295;

import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;

    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((x, y) -> y - x);
    }

    public void addNum(int num) {
        if (large.size() > small.size()) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
    }

    public double findMedian() {
        if (large.size() > small.size()) {
            return large.peek();
        } else if (large.size() < small.size()) {
            return small.peek();
        } else {
            return (large.peek() + small.peek()) / 2.0;
        }
    }
}
