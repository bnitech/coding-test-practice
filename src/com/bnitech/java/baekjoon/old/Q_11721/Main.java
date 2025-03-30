package com.bnitech.acmicpc.Q_11721;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        new Main().result(br.readLine());
    }

    public void result(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            if(i+9 < chars.length){
                for (int j = i; j < i+10; j++) {
                    System.out.print(chars[j]);
                }
                i = i+9;
            }else{
                for (int j = i; j < chars.length; j++) {
                    System.out.print(chars[j]);
                }
                i = chars.length;
            }
            System.out.println();
        }
    }
}
