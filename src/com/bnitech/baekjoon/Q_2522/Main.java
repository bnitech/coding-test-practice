package com.bnitech.acmicpc.Q_2522;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        new Main().result();
    }
    public void result(){
        Scanner input = new Scanner(System.in);
        int numN = input.nextInt();
        for(int i=1; i <= numN; i++){
            for(int empty= numN-i; empty >=1; empty--){
                System.out.print(" ");
            }
            for(int star=1; star<=i; star++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=numN-1; i>=1; i--){
            for(int empty=1; empty<=numN-i; empty++){
                System.out.print(" ");
            }
            for(int star=i; star>=1; star--){
                System.out.print("*");
            }
            if(i!=1) System.out.println();
        }
    }
}
