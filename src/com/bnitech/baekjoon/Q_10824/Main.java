package com.bnitech.acmicpc.Q_10824;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        new Main().result();
    }
    public void result(){
        Scanner input = new Scanner(System.in);
        String[] str = input.nextLine().split(" ");
        StringBuilder sb = new StringBuilder(str[0]);
        sb.append(str[1]);
        long sumLeft = Long.parseLong(sb.toString());

        sb = new StringBuilder(str[2]);
        sb.append(str[3]);
        long sumRight =  Long.parseLong(sb.toString());

        System.out.print(sumLeft+sumRight);
    }
}
