package com.bnitech.acmicpc.Q_1406;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().result();
    }

    public void result() {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(input.next());
        int pointer = sb.length();
        int line = input.nextInt();
        while (line-- > 0) {
            switch (input.next()) {
                case "L": {
                    if (pointer != 0) pointer--;
                    break;
                }
                case "D": {
                    if (pointer != sb.length()) pointer++;
                    break;
                }
                case "B": {
                    if(pointer != 0){
                        sb.delete(pointer-1,pointer);
                        pointer--;
                    }
                    break;
                }
                case "P": {
                    String tmp = input.next();
                    sb.insert(pointer,tmp);
                    pointer += tmp.length();
                    break;
                }
                default: {
                    System.out.println("ERROR");
                    break;
                }
            }
        }
        System.out.print(sb.toString());

    }
}
