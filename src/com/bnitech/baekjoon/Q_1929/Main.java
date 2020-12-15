/*
수학-에라토스테네스의 체-소수구하기
 */


package com.bnitech.acmicpc.Q_1929;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num_N = Integer.parseInt(st.nextToken());
        int num_M = Integer.parseInt(st.nextToken());


        boolean[] checkRemove = new boolean[num_M+1];
        ArrayList<Integer> arrList_primes = new ArrayList<>();
        for (int i = 2; i <= num_M ; i++) {
            if(!checkRemove[i]){
                if(i >= num_N) arrList_primes.add(i);
                for (int j = i+i; j <= num_M ; j+=i) {
                    checkRemove[j] = true;
                }
            }
        }

        for (int output:arrList_primes) {
            System.out.println(output);
        }
    }
}
