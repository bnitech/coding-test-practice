/*
수학-소인수분해-소인수분해
 */

package com.bnitech.acmicpc.Q_11653;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        new Main().result();
    }
    public void result() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_N = Integer.parseInt(br.readLine());
        for (int i = 2; i*i <=num_N ; i++) {
            while (num_N%i==0){
                System.out.println(i);
                num_N/=i;
            }
        }
        if(num_N>1)System.out.println(num_N);
    }
}
