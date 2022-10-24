package leetcode.question0215;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    @Test
    void test() {
        findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x));
        for (int num : nums) {
            priorityQueue.offer(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.peek();
    }
}
