/*
https://koosa.ga/recommend
알파벳 찾기
 */

package com.bnitech.acmicpc.Q_10809;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str_S = br.readLine();
        int len_S = str_S.length();
        int[] check_alpa = new int[26];

        for (int i = 0; i < 26 ; i++) {
            check_alpa[i] = -1;
        }
        for (int i = 0; i < len_S ; i++) {
            int num_alpa = str_S.charAt(i) - 'a';
            if (check_alpa[num_alpa] == -1) {
                check_alpa[num_alpa] = i;
            }
        }

        for (int num : check_alpa) {
            System.out.print(num+" ");
        }
    }
}
