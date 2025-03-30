package com.bnitech.acmicpc.Q_10818;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        new Main().result();
    }
    public void result(){

        Scanner input = new Scanner(System.in);
        int numN = input.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<numN; i++){
            list.add(input.nextInt());
        }
        Collections.sort(list);

        System.out.println(list.get(0)+" "+list.get(list.size()-1));

    }
}
