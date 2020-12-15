package com.bnitech.acmicpc.Q_9465;

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
        int numT = Integer.parseInt(st.nextToken());
        while (numT-- > 0) {
            st = new StringTokenizer(br.readLine());
            int numN = Integer.parseInt(st.nextToken());
            int[][] tile = new int[numN + 1][2];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= numN; i++) {
                tile[i][0] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= numN; i++) {
                tile[i][1] = Integer.parseInt(st.nextToken());
            }
//            세로줄의 3가지 경우
//            1. 0을 떼거나	0
//            2. 1을 떼거나	1
//            3. 떼지 않거나 2
            int[][] memoTile = new int[numN + 1][3];
            memoTile[1][0] = tile[1][0];
            memoTile[1][1] = tile[1][1];
            for (int N = 2; N <= numN; N++) {
                int max = 0;

//              0   1
                max = memoTile[N - 1][1];
//              0   2
                if (max < memoTile[N - 1][2]) max = memoTile[N - 1][2];

                memoTile[N][0] = tile[N][0] + max;

//              1   0
                max = memoTile[N - 1][0];
//              0   2
                if (max < memoTile[N - 1][2]) max = memoTile[N - 1][2];

                memoTile[N][1] = tile[N][1] + max;

//              2   0
                max = memoTile[N - 1][0];
//              2   1
                if (max < memoTile[N - 1][1]) max = memoTile[N - 1][1];
//              2   2
                if (max < memoTile[N - 1][2]) max = memoTile[N - 1][2];

                memoTile[N][2] = max;

            }
            int score = 0;
            for (int i = 0; i < 3; i++) {
                if (score < memoTile[numN][i]) score = memoTile[numN][i];
            }
            System.out.println(score);
        }
    }
}
