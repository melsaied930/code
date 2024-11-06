package problems;

import java.util.Arrays;

/*
https://leetcode.com/problems/product-of-array-except-self/description/
238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
*/
public class ProductExceptSelf {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] out = productExceptSelf(nums);
//        System.out.println("Output: " + Arrays.toString(out));
//        out = productExceptSelf1(nums);
//        System.out.println("Output1: " + Arrays.toString(out));
//        out = productExceptSelf2(nums);
//        System.out.println("Output2: " + Arrays.toString(out));
        out = productExceptSelf3(nums);
        System.out.println("Output3: " + Arrays.toString(out));
        out = productExceptSelf4(nums);
        System.out.println("Output4: " + Arrays.toString(out));
    }

    private static int[] productExceptSelf4(int[] nums) {
        int prefix = 1;
        int postfix = 1;
        int n = nums.length;
        int[] product = new int[n];
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            product[i] = prefix;
            prefix *= nums[i];

            product[j] *= postfix;
            postfix *= nums[j];

            System.out.println("i: " + i + " - " + ", j: " + j + " - " + ", prefix: " + prefix + " - " + ", postfix: " + postfix + " - " + ", nums: " + Arrays.toString(nums) + " - " + ", product: " + Arrays.toString(product));
        }
        return product;
    }

    public static int[] productExceptSelf3(int[] nums) {
        int prefix = 1;
        int postfix = 1;
        int n = nums.length;
        int[] product = new int[n];
        for (int i = 0; i < n; i++) {
            product[i] = prefix;
            prefix *= nums[i];
            System.out.println("i: " + i +
                    " - " + ", prefix: " + prefix + " - " + ", postfix: " + postfix + " - " + ", nums: " + Arrays.toString(nums) + " - " + ", product: " + Arrays.toString(product));
        }
        System.out.println();
        for (int i = n - 1; i >= 0; i--) {
            product[i] *= postfix;
            postfix *= nums[i];
            System.out.println("j: " + i +
                    " - " + ", prefix: " + prefix + " - " + ", postfix: " + postfix + " - " + ", nums: " + Arrays.toString(nums) + " - " + ", product: " + Arrays.toString(product));
        }
        System.out.println();
        System.out.println();
        return product;
    }

    private static int[] productExceptSelf2(int[] nums) {
        int[] out = new int[nums.length];
        int n = nums.length;
        // Base case
        if (n == 1) {
            System.out.print("0");
            return out;
        }

        int i, temp = 1;

        /* Allocate memory for the product array */
        int[] prod = new int[n];

        /* Initialize the product array as 1 */
        Arrays.fill(prod, 1);

        /* In this loop, temp variable contains product of
           elements on left side excluding arr[i] */
        for (i = 0; i < n; i++) {
            prod[i] = temp;
            temp *= nums[i];
        }

        /* Initialize temp to 1 for product on right side */
        temp = 1;

        /* In this loop, temp variable contains product of
           elements on right side excluding arr[i] */
        for (i = n - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= nums[i];
        }
        return prod;
    }

    private static int[] productExceptSelf1(int[] nums) {
        int[] out = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                product *= nums[j];
            }
            out[i] = product;
        }
        return out;
    }

    private static int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            out[i] = product;
        }
        return out;
    }
}
