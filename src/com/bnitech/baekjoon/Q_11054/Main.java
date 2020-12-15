package com.bnitech.acmicpc.Q_11054;

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

        // down : 0, up : 1
        int[][] memoLen = new int[2][numN];
        memoLen[0][0] = 1;
        memoLen[1][0] = 1;
        for (int N = 1; N < numN; N++) {
            for (int K = N - 1; K >= 0; K--) {
                if (su[N] > su[K]){
                    if(memoLen[0][N] < memoLen[0][K]) memoLen[0][N] = memoLen[0][K];
                }else if(su[N] < su[K]){
                    if(memoLen[1][N] < memoLen[1][K]) memoLen[1][N] = Math.max(memoLen[0][K],memoLen[1][K]);
                }
            }
            memoLen[0][N]++;
            memoLen[1][N]++;
        }
        Arrays.sort(memoLen[0]);
        Arrays.sort(memoLen[1]);
        System.out.println(Math.max(memoLen[0][numN-1],memoLen[1][numN-1]));
    }
}
