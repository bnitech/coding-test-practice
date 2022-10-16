/*
수학-팩토리얼-팩토리얼
 */

package com.bnitech.acmicpc.Q_10872;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_N = Integer.parseInt(br.readLine());

        int sum = 1;
        while (num_N>1){
            sum*=num_N--;
        }
        System.out.println(sum);
    }
}
