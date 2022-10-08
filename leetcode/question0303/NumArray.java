package leetcode.question0303;

class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int result = 0;
        for (; left < right; left++) {
            result += this.nums[left];
        }
        return result;
    }
}
