package test;
/*
Problem Statement
Pat is working on cracking an online gambling game. Given a list of numbers, write a program to calculate the Gambling factors using the following procedure:
1.Find the root Ri of all perfect squares present in the list.
2.Find out gambling factor Gi for each of the root Ri found in Step 1.
Gambling factor Gi = Last 3 non-zero digits of Ri!
3. Print -1 if atleast one gambling factor cannot be generated.
Input format:
Read the list of number separated by space from the from the standard input.
Output format:
Print the root of perfect squares separated by space in the first line arranged in ascending order. Print -1 if there are no such roots
Print the gambling factors separated by space in the second line arranged in ascending order. Print the output to the standard output.
-----------------------------------------------------------
Sample Input
2 4 6 9 81 25 100 144
Sample Output
2 3 5 9 10 12
2 6 12 16 288 288
Explanation
In first line, 2 is square root of 4, 3 is of 9, 5 is of 25, 9 is of 81 etc, and all are printed in ascending order.
In next line, factorial of 2 is 2*1=2 so output is 2, factorial of 3 is 3*2*1=6 so output is 6, factorial of 5 is 5*4*3*2*1=120, eliminating the 0, the output is 12, factorial of 9 is 362880, eliminating 0 the last 3 digits will be 288.
-----------------------------------------------------------
Sample Input
2 3 5 6 7 8
Sample Output
-1
Explanation
there are no perfect squares present in the list so -1 will be printed
*/


import java.util.Arrays;
import java.util.Scanner;

class myCode {
    public static void main(String[] arrg) throws Exception {

        Scanner s = new Scanner(System.in);
        String inputString = s.nextLine();

        String[] arr = inputString.split(" ");
        int[] out = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int j = Integer.parseInt(arr[i]);
            double k = Math.sqrt(j);
            int l = (int) k;
            if (k == l) {
                out[i] = l;
            } else {
                out[i] = 0;
            }
        }
        Arrays.sort(out);
        for (int o : out) {
            if (o != 0) {
                System.out.print(o + " ");
            }
        }
        System.out.println("");
        for (int i = 0; i < out.length; i++) {
            int x=1;
            for (int j = 0; j < out.length; j++) {

                if (out[i] != 0) {
                     x = out[j];
                }
            }
            System.out.println(x+" ");
        }
//        System.out.println("Hello");
    }
}
