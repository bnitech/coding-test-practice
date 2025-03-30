/*
수학-소수-소수 찾기
 */

package com.bnitech.acmicpc.Q_1978;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        new Main().result();
    }
    public void result() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len_N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count =0 ;
        for (int i = 0; i < len_N ; i++) {
            int num_N = Integer.parseInt(st.nextToken());
            if(checkPrime(num_N)) count++;
        }
        System.out.println(count);
    }
    public boolean checkPrime(int num){
        if(num < 2) return false;
        else if(num == 2) return true;
        for (int i = 2; i*i <= num ; i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}
