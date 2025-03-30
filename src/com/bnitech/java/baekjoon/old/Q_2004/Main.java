/*
수학-조합 0의 개수-조합 0의 개수
 */

package com.bnitech.acmicpc.Q_2004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long num_N = Integer.parseInt(st.nextToken());
        long num_M = Integer.parseInt(st.nextToken());
        long sumCount_5 = 0;
        long sumCount_2 = 0;

//      N!/(M!*(N-M)!)
        sumCount_2 += count_2(num_N);
        sumCount_2 -= count_2(num_M);
        sumCount_2 -= count_2(num_N - num_M);

        sumCount_5 += count_5(num_N);
        sumCount_5 -= count_5(num_M);
        sumCount_5 -= count_5(num_N - num_M);

        if (sumCount_2 < sumCount_5) {
            System.out.println(sumCount_2);
        }else{
            System.out.println(sumCount_5);
        }
    }

    public long count_2(long num_N) {
        long count_2 = 0;
        for (long i = 2; i <= num_N; i *= 2) {
            count_2 += num_N / i;
        }
        return count_2;
    }

    public long count_5(long num_N) {
        long count_5 = 0;
        for (long i = 5; i <= num_N; i *= 5) {
            count_5 += num_N / i;
        }
        return count_5;
    }
}
