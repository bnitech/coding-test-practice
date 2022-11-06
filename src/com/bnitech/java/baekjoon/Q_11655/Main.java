package com.bnitech.acmicpc.Q_11655;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        new Main().result();
    }

    public void result() {
        Scanner input = new Scanner(System.in);

        String strLine = input.nextLine();
        String[] str = strLine.split(" ");
        int strLen = str.length;
        for (int k = 0; k < strLen ; k++) {
            int len = str[k].length();
            for (int i = 0; i < len; i++) {
                int ascii = str[k].charAt(i);
                if (ascii>= 65 && ascii <= 90) {
                   if(ascii+13>90){
                       ascii -= 26;
                   }
                    System.out.print((char)(ascii+13));
                } else if (ascii >= 97 && ascii <= 122) {
                    if(ascii+13>122){
                        ascii -= 26;
                    }
                    System.out.print((char)(ascii+13));
                }else{
                    System.out.print((char)ascii);
                }
            }
            if(k == strLen-1){
            }else{
                System.out.print(" ");
            }

        }
    }
}
