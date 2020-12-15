package com.bnitech.baekjoon.문제_1100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public StringTokenizer st = new StringTokenizer("");

    public static void main(String[] args) throws Exception {
        new Main().start();
    }

    public void start() throws Exception {

        int count = 0;
        for (int i = 0; i < 8; i++) {
            st = new StringTokenizer(br.readLine());
            char[] tmpChar = st.nextToken().toCharArray();
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        if ('F' == tmpChar[j]) {
                            count++;
                        }
                    }
                } else if (i % 2 == 1) {
                    if (j % 2 == 1) {
                        if ('F' == tmpChar[j]) {
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
