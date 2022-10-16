/*
트리-트리 순회
 */

package com.bnitech.acmicpc.Q_1991;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int num_V;
    public static int[][] arr_V;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num_V = Integer.parseInt(br.readLine());

//      char to int ('A' -> 0)
        arr_V = new int[num_V][2];
        for (int i = 0; i < num_V; i++) {
            String str_V = br.readLine();
            int[] child = new int[3];
            child[0] = str_V.charAt(0) - 'A';
            child[1] = str_V.charAt(2) - 'A';
            child[2] = str_V.charAt(4) - 'A';

            if (0 <= child[1] && child[1] <= 25) {
                arr_V[child[0]][0] = child[1];
            } else {
                arr_V[child[0]][0] = -1;
            }
            if (0 <= child[2] && child[2] <= 25) {
                arr_V[child[0]][1] = child[2];
            } else {
                arr_V[child[0]][1] = -1;
            }
        }

        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
        System.out.println();
    }

    static void preorder(int V) {
        if (V == -1) return;
        System.out.print((char) (V + 'A'));
        preorder(arr_V[V][0]);
        preorder(arr_V[V][1]);
    }

    static void inorder(int V) {
        if (V == -1) return;
        inorder(arr_V[V][0]);
        System.out.print((char) (V + 'A'));
        inorder(arr_V[V][1]);
    }

    static void postorder(int V) {
        if (V == -1) return;
        postorder(arr_V[V][0]);
        postorder(arr_V[V][1]);
        System.out.print((char) (V + 'A'));
    }
}