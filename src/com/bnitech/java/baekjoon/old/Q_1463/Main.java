package com.bnitech.acmicpc.Q_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        new Main().result(br.readLine());
    }

    public void result(String input) {
        int numN = Integer.parseInt(input);
        int[] minCount = new int[numN + 1];

        for (int i = 2; i <= numN; i++) {
            int count = 1;
            if (i % 3 == 0) {
                if (minCount[i - 1] < minCount[i / 3]) {
                    count += minCount[i - 1];
                } else {
                    count += minCount[i / 3];
                }
            } else if (i % 2 == 0) {
                if (minCount[i - 1] <= minCount[i / 2]) {
                    count += minCount[i - 1];
                } else {
                    count += minCount[i / 2];
                }
            } else {
                count += minCount[i - 1];
            }

            minCount[i] = count;
        }

        System.out.println(minCount[numN]);

    }
}
