package com.bnitech.java.baekjoon.v25.q12865;

import java.util.Arrays;
import java.util.Scanner;

/*
4 7
6 13
4 8
3 6
5 12
 */

/*
4 7
1 50
2 60
3 30
4 40
 */

public class Main {
    public static void main(String[] args) {
        solution();

//        String a = new String();
//        a.substring()
    }
    public static void solution(){
        Scanner input = new Scanner(System.in);
        final int N = input.nextInt();
        final int K = input.nextInt();

        int[][] arr = new int[K+1][N];
        Tool[] tools = new Tool[N];
        for(int i = 0; i < N; i++){
            final int W = input.nextInt();
            final int V = input.nextInt();
            tools[i] = new Tool(W, V);
            arr[W][i] = V;
        }

        for (int i = 0; i <= K; i++) {
            for (int j = 0; j < N; j++) {
                Tool tool = tools[j];

                if(i - tool.W < 0){
                    continue;
                }

                arr[i][j] = max(arr[tool.W]) + max(arr[i - tool.W]);
                print(arr);
            }
        }

        System.out.println(max(arr[K]));
    }

    public static int max(int[] target){
        int max = 0;
        for (int i = 0; i < target.length; i++) {
            if(max < target[i]){
                max = target[i];
            }
        }
        return max;
    }

    public static class Tool{
        public int W;
        public int V;
        Tool(int W, int V){
            this.W = W;
            this.V = V;
        }
    }

    public static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("=====================");
    }
}
