package problems;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter: ");
        String input=scanner.nextLine();
        System.out.println(input);
    }
}
