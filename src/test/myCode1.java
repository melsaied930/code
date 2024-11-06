package test;
/*
Problem Statement
Matt works as a security officer in Milton golf links.
He tracks the entry and exit of all the vehicles at the main gate.
The management has requested him to track the vehicles with special registration number as they might get a chance to win goodies.
The registration numbers that have unique digits which are ordered are considered to be special.
E.g, KA-09-AB-4589 is eligible for a goodie as 4589 is in arranged in ascending order where KA-09-AB-3124 is not eligible.
Given a string S containing the registration number of all the vehicles tracked by Matt, write a program to print the number of vehicle owners who have the chance to win goodies.
Input and Output Format :
Read the comma separated vehicle registration number from standard input stream. Print the output to the standard output stream

Sample Input
KA-09-HF-4352, OR-02-AG-5824, MP-01-RE-4321, TN-04-KA-4566, KA-09-HF-9844
Sample Output
3
Explanation
Owners of MP-01-RE-4321, TN-04-KA-4566, KA-09-HF-9844 stand a chance to win goodies

Sample Input
KA-09-HF-4352, OR-02-AG-5824, MP-01-RE-4323, TN-04-KA-4566, KA-09-HF-9844, KA-09-HF-4352, OR-05-AG-5880, MP-03-FR-0199
Sample Output
3
Explanation
Owners of TN-04-KA-4566, MP-03-FR-0199, KA-09-HF-9844 stand a chance to win goodies
*/


//import java.util.Arrays;
//import java.util.Scanner;

//class myCode1 {
//    public static void main(String[] arrg) throws Exception {
//
//        Scanner s = new Scanner(System.in);
//        String inputString = s.nextLine();
//        String[] arr = inputString.split(" ");
//        int[] out = new int[arr.length];
//
//
//    }
//}

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class myCode1 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        String inputString = s.nextLine();
        int winners = 0;
        String[] arr = inputString.split(", ");
        for (String string : arr) {
            String number = string.substring(string.lastIndexOf('-') + 1);
            char[] chars = number.toCharArray();
            Integer[] its = new Integer[chars.length];
            Arrays.setAll(its, i -> Character.getNumericValue(chars[i]));
            Integer[] intoAscending = Arrays.copyOf(its, its.length);
            Integer[] intoDescending = Arrays.copyOf(its, its.length);
            Arrays.sort(intoAscending);
            Arrays.sort(intoDescending, Collections.reverseOrder());
            if (Arrays.equals(its, intoAscending) || Arrays.equals(its, intoDescending)) {
                winners++;
                System.out.println(string);
            }
        }
        System.out.println(winners);
//        System.out.println("Hello");
    }
}
       /*
KA-09-HF-4352, OR-02-AG-5824, MP-01-RE-4321, TN-04-KA-4566, KA-09-HF-9844
       * */