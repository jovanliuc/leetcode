package leetcode.question0295;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        MedianFinder obj = new MedianFinder();
        obj.addNum(3);
        obj.addNum(2);
        obj.addNum(7);
        obj.addNum(2);
        obj.addNum(10);
        obj.addNum(2);
        obj.addNum(3);
        obj.addNum(9);
        obj.addNum(11);
        obj.addNum(1);
        obj.addNum(8);
        double mid = obj.findMedian();
        System.out.println(mid);
    }
}
