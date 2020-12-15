package com.bnitech.acmicpc.Q_4673;

public class Main {

    public static void main(String[] args) {

        new Main().result(10000);
    }

    public void result(int k) {

        boolean[] sangsung = new boolean[k * 10];
        int su = 0;
        int tmp = 0;
        for (int i = 1; i <= k; i++) {
            tmp = i;
            su = tmp;
            if (tmp >= 1000) {
                su += tmp % 10;
                tmp = tmp / 10;
            }
            if (tmp >= 100) {
                su += tmp % 10;
                tmp = tmp / 10;
            }
            if (tmp >= 10 ) {
                su += tmp % 10;
                tmp = tmp / 10;
            }
            if (tmp < 10) {
                su += tmp;
            }
            sangsung[su] = true;
        }
        for (int i = 1; i <= k; i++) {
            if (!sangsung[i])
                System.out.println(i);
        }

    }
}
