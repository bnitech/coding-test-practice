package com.bnitech.acmicpc.Q_11055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numN = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] su = new int[numN];
        for (int i = 0; i < numN; i++) {
            su[i] = Integer.parseInt(st.nextToken());
        }

        int[] memoMax = new int[numN];

        for (int N = 0; N <numN ; N++) {
            for (int K = N-1; K >= 0 ; K--) {
                if(su[N] > su[K]){
                    if(memoMax[N] < memoMax[K]) memoMax[N] = memoMax[K];
                }
            }
            memoMax[N] += su[N];
        }

        Arrays.sort(memoMax);
        System.out.println(memoMax[numN-1]);
    }
}
