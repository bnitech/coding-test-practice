/*
수학-골드바흐의 추측-골드바흐의 추측
 */

package com.bnitech.acmicpc.Q_6588_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
        new Main().result();
    }
    public void result() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        6 <= n <= 1000000
        boolean[] isNotPrime = new boolean[1000000+1];
        ArrayList<Integer> arrList_prime = new ArrayList<>();
        setPrimes(isNotPrime,arrList_prime, 1000000);

        int num_N = Integer.parseInt(br.readLine());
        while (num_N != 0){
            boolean print = false;
            for(Integer num_A:arrList_prime){
                int num_B = num_N-num_A;
                if(isNotPrime[num_B]==false){
                    System.out.println(num_N+" = "+num_A+" + "+num_B);
                    print = true;
                    break;
                }
            }
            if(print==false)System.out.println("Goldbach's conjecture is wrong.");
            num_N = Integer.parseInt(br.readLine());
        }
    }
    public void setPrimes(boolean[] isNotPrime,ArrayList<Integer> arrList_prime, int max_N){
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i <=max_N ; i++) {
            if(isNotPrime[i]==false) {
                arrList_prime.add(i);
                for (int j = i + i; j <= max_N; j  += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }
}
