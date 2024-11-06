/*
Maximum Product Subarray

Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/
package problems;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4};  //  Output: 6   //  Explanation: [2,3] has the largest product 6.
//        nums = new int[]{-2, 0, -1}; //  Output: 0   //  Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
//        nums = new int[]{0, 2}; //   Expected 2
        int out = new MaximumProductSubarray().maxProduct(nums);
        System.out.println("Output: " + out);
    }

    private int maxProduct(int[] nums) {
        int returnMax = nums[0];
        int runningMin = nums[0];
        int runningMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = runningMax * nums[i];
            int min = runningMin * nums[i];
            int newMax = Math.max(min, max);
            runningMin = Math.min(min, runningMax * nums[i]);
            if (newMax < 0) {
                runningMax = 1;
            } else {
                runningMax = newMax;
            }
            returnMax = Math.max(returnMax, runningMax);
        }
        return returnMax;
    }
}
