package problems;

class Solution2 {
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int max = 0;
        int runningSum = nums[0];
        // 1,2,3,4,5,-1,-3,-1,6,7,8
        for (int i = 0; i < size; i++) {
            if (runningSum < 0) {
                runningSum = nums[i];
            } else {
                runningSum += nums[i];
            }
            max = max > runningSum ? max : runningSum;
        }
        return size;
    }
}
