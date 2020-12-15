/*
https://koosa.ga/recommend
단어 공부
 */

package com.bnitech.acmicpc.Q_1157;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str_S = br.readLine();

        int len_S = str_S.length();
        int[] check_alpha = new int[26];

        for (int i = 0; i < len_S; i++) {
            char char_alpha = str_S.charAt(i);
            if (char_alpha >= 'a') {
                int num_alpha_small = str_S.charAt(i) - 'a';
                check_alpha[num_alpha_small]++;
            } else {
                int num_alpha_big = str_S.charAt(i) - 'A';
                check_alpha[num_alpha_big]++;
            }
        }
        int max_alpha[] = new int[2];
        for (int i = 0; i <26 ; i++) {
            if(check_alpha[i] > max_alpha[0]){
                max_alpha[0] = check_alpha[i];
                max_alpha[1] = i;
            }
        }

        for (int i = 0; i <26 ; i++) {
            if(check_alpha[i] ==  max_alpha[0] && i != max_alpha[1]){
                System.out.println("?");
                return;
            }
        }

        System.out.println((char)(max_alpha[1]+'A'));


    }
}
