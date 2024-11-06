package test;

/*
Problem Statement
Infosys needs a Cryptography program to deal with sensitive information. For that purpose the following program contains the Move to Front algorithm. The move to Front algorithm is explained as below:-
Given a symbol table of a zero-indexed array of all possible input symbols this algorithm reversibly transforms a sequence of input symbols into an array of output numbers (indices).
The transform in many cases acts to give frequently repeated input symbols lower indices which is useful in some compression algorithms.

Encoding algorithm:-

     For each symbol of the input sequence:

Output the index of the symbol in the symbol table
Move that symbol to the front of the symbol table
Decoding algorithm:-

    Using the same starting symbol table, For each index of the input sequence:

Output the symbol at that index of the symbol table
Move that symbol to the front of the symbol table
There will be two inputs first will be 0 or 1 (0 for encode and 1 for decode),

For Encode the input will be a string which will output a encoded message,

For Decode the input will be length of the list in the first line followed by line seperated list of numbers between 0 and 25.

Example-
Encoding the string of character symbols 'broood' using a symbol table of the characters 'a'-to-'z'

Input       Output              SymbolTable
broood     1                    'abcdefghijklmnopqrstuvwxyz'
broood     1 17               'bacdefghijklmnopqrstuvwxyz'
broood     1 17 15           'rbacdefghijklmnopqstuvwxyz'
broood     1 17 15 0        'orbacdefghijklmnpqstuvwxyz'
broood     1 17 15 0 0     'orbacdefghijklmnpqstuvwxyz'
broood     1 17 15 0 0 5  'orbacdefghijklmnpqstuvwxyz'

Decoding the indices back to the original symbol order:

Input              Output                    SymbolTable
1 17 15 0 0 5      b                'abcdefghijklmnopqrstuvwxyz'
1 17 15 0 0 5      br               'bacdefghijklmnopqrstuvwxyz'
1 17 15 0 0 5      bro             'rbacdefghijklmnopqstuvwxyz'
1 17 15 0 0 5      broo           'orbacdefghijklmnpqstuvwxyz'
1 17 15 0 0 5      brooo         'orbacdefghijklmnpqstuvwxyz'
1 17 15 0 0 5      broood       'orbacdefghijklmnpqstuvwxyz'

Sample Input
0
brooood
Sample Output
[1, 17, 15, 0, 0, 0, 5]

Sample Input
1
7
1
17
15
0
0
0
5

Sample Output
brooood

*/


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class MTF{
    public static List<Integer> encode(String msg, String symTable){
        List<Integer> output = new LinkedList<Integer>();
        StringBuilder s = new StringBuilder(symTable);
        for(char c: msg.toCharArray()){
//            int idx = s.indexOf(c);
//            output.add(idx);
//            s = s.deleteCharAt(idx).insert(1, c);
        }
        return output;
    }

    public static String decode(List<Integer> idxs, String symTable){
        StringBuilder output = new StringBuilder();
        StringBuilder s = new StringBuilder(symTable);
        for(int idx : idxs){
            char c = s.charAt(idx);
            output = output.append(c);
            s = s.deleteCharAt(idx).insert(0, c);
        }
        return output.toString();
    }

    public static void main(String[] args){
        String symTable = "abcdefghijklmnopqrstuvwxyz";
        Scanner scanner = new Scanner(System.in);
        Integer num = Integer.parseInt(scanner.next());
        if(num==0){
            String str=scanner.next();
            List<Integer> encoded = encode(str, symTable);
            System.out.println(encoded);
        }
        else{
            int len=scanner.nextInt();
            List<Integer> input = new LinkedList<Integer>();
            for(int i=0;i<len;i++)
            {
                num = scanner.nextInt();
                input.add(num);
            }
            String decoded = decode(input, symTable);
            System.out.println(decoded);
        }
    }


}