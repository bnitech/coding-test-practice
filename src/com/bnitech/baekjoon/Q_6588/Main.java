/*
수학-골드바흐의 추측-골드바흐의 추측
 */

package com.bnitech.acmicpc.Q_6588;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        new Main().result();
    }
    public void result() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        6 <= n <= 1000000
        boolean[] isNotPrime = new boolean[1000000+1];
        setPrimes(isNotPrime, 1000000);

        int num_N = Integer.parseInt(br.readLine());;
        while (num_N != 0){
            boolean print = false;
            int num_A =0 ;
            int num_B =0 ;
            for (int i = 2; i <= num_N ; i++) {
                if(isNotPrime[i]==false && isNotPrime[num_N-i]== false){
                    print = true;
                    num_A = i;
                    num_B = num_N-i;
                    break;
                }
            }
            if(print) System.out.println(num_N+" = "+num_A+" + "+num_B);
            else System.out.println("Goldbach's conjecture is wrong.");
            num_N = Integer.parseInt(br.readLine());
        }
    }
    public void setPrimes(boolean[] isNotPrime, int max_N){
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i <=max_N ; i++) {
            if(isNotPrime[i]==false) {
                for (int j = i + i; j <= max_N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }
}
