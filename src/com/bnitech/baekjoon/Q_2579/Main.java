package com.bnitech.acmicpc.Q_2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        new Main().result();
    }
    public void result() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        int[][] maxValue = new int[len+1][3];
        maxValue[1][1] = Integer.parseInt(br.readLine());
        for (int i = 2; i <=len ; i++) {
            int num = Integer.parseInt(br.readLine());
            maxValue[i][1] = num + Math.max(maxValue[i-2][1],maxValue[i-2][2]);
            maxValue[i][2] = num + maxValue[i-1][1];
        }

        System.out.println(Math.max(maxValue[len][1],maxValue[len][2]));
    }
}
