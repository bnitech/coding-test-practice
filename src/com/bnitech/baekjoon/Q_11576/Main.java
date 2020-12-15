/*
수학-Base Conversion-Base Conversion
 */


package com.bnitech.acmicpc.Q_11576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num_A = Integer.parseInt(st.nextToken());
        int num_B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int len_A = Integer.parseInt(st.nextToken());

        int num_10 = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = len_A-1; i >= 0; i--) {
            int int_A = Integer.parseInt(st.nextToken());
            num_10 +=int_A * (int)Math.pow(num_A,i);
        }

        ArrayList<Integer> arrList_B = new ArrayList<>();
        while (num_10>0){
            arrList_B.add(0,num_10%num_B);
            num_10/=num_B;
        }

        for (int output:arrList_B) {
            System.out.print(output+" ");
        }
    }
}
