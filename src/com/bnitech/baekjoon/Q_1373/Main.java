/*
수학-Base Conversion-2진수 8진수
 */

package com.bnitech.acmicpc.Q_1373;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str_2 = st.nextToken();
        int len_2 = str_2.length();
        StringBuilder sb_8 = new StringBuilder();
        //2진수 3자리씩 끊기
        for (int i = len_2; i > 0; i-=3) {
            int num_su_8 = 0;
            if(i<3){
                for (int j = 0; j <i ; j++) {
                    num_su_8 += (str_2.charAt(i-1-j)-'0')*Math.pow(2,j);
                }
            }else {
                for (int j = 0; j < 3; j++) {
                    num_su_8 += (str_2.charAt(i-1-j)-'0')*Math.pow(2,j);
                }
            }

            //3자리 합으로 8진수 만들기
            sb_8.insert(0,num_su_8);
        }
        System.out.println(sb_8.toString());


    }

}
