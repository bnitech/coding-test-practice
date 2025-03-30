/*
정렬-정렬 응용하기-카드
 */

package com.bnitech.acmicpc.Q_11652;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_N = Integer.parseInt(br.readLine());
        long [] cards = new long[num_N];
        for (int i = 0; i < num_N; i++) {
            cards[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(cards);

        int cnt = 1, max = 1;
        long output = cards[0];
        for (int i = 1; i < num_N; i++) {
            if (cards[i - 1] == (cards[i])) {
                cnt++;

            } else {
                cnt = 1;
            }
            if (cnt > max){
                max = cnt;
                output = cards[i];
            }
        }
        System.out.println(output);
    }
}
