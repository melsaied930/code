/*
100285. Find the Integer Added to Array I

You are given two arrays of equal length, numss1 and numss2.
Each element in numss1 has been increased (or decreased in the case of negative) by an integer, represented by the variable x.
As a result, numss1 becomes equal to numss2. Two arrays are considered equal when they contain the same integers with the same frequencies.
Return the integer x.

Example 1:
Input: numss1 = [2,6,4], numss2 = [9,7,5]
Output: 3
Explanation:
The integer added to each element of numss1 is 3.

Example 2:
Input: numss1 = [10], numss2 = [5]
Output: -5
Explanation:
The integer added to each element of numss1 is -5.

Example 3:
Input: numss1 = [1,1,1,1], numss2 = [1,1,1,1]
Output: 0
Explanation:
The integer added to each element of numss1 is 0.

Constraints:
1 <= numss1.length == numss2.length <= 100
0 <= numss1[i], numss2[i] <= 1000
The test cases are generated in a way that there is an integer x such that numss1 can become equal to numss2 by adding x to each element of numss1.
*/
package contest;

public class Contest395 {
    public static void main(String[] args) {
        int[] nums1 = {2, 6, 4};
        int[] nums2 = {9, 7, 5};
        int x = addedInteger(nums1, nums2);
        System.out.println("Output: " + x);

        nums1 = new int[]{4, 20, 16, 12, 8};
        nums2 = new int[]{14, 18, 10};
        x = addedInteger1(nums1, nums2);
        System.out.println("Output: " + x);
    }

    private static int addedInteger1(int[] nums1, int[] nums2) {
        int max1 = nums1[0];
        int max2 = nums2[0];
        for (int i = 0; i < nums1.length; i++) {
            max1 = max1 < nums1[i] ? nums1[i] : max1;
        }
        for (int i = 0; i < nums2.length; i++) {
            max2 = max2 < nums2[i] ? nums2[i] : max2;
        }
//        System.out.println("min1 = " + max1);
//        System.out.println("min2 = " + max2);
        return max2 - max1;
    }

    private static int addedInteger(int[] nums1, int[] nums2) {
        int min1 = nums1[0];
        int min2 = nums2[0];
        for (int i = 0; i < nums1.length; i++) {
            min1 = min1 < nums1[i] ? min1 : nums1[i];
            min2 = min2 < nums2[i] ? min2 : nums2[i];
        }
        return min2 - min1;
    }
}
