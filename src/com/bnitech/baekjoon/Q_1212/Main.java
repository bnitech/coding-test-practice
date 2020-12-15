/*
수학-Base Conversion-8진수 2진수
 */

package com.bnitech.acmicpc.Q_1212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str_8 = st.nextToken();
        StringBuilder sb_2 = new StringBuilder();
        int len_8 = str_8.length();

        String[] strs_8to2_first = {"0","1","10","11","100","101","110","111"};
        String[] strs_8to2 = {"000","001","010","011","100","101","110","111"};

        for (int i = 0; i < len_8; i++) {
            int num_su_8 = (str_8.charAt(i)-'0');
            if(i==0) System.out.print(strs_8to2_first[num_su_8]);
            else System.out.print(strs_8to2[num_su_8]);
        }

    }
}
