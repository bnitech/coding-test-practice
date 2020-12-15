/*
수학-BAse Conversion-진법 변환
 */

package com.bnitech.acmicpc.Q_2745;

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
        String str_N = st.nextToken();
        int num_B = Integer.parseInt(st.nextToken());
        double sum = Bto10(str_N,num_B);

        System.out.println((long)sum);
    }
    public double Bto10(String str_N, int num_B){
        int len_N = str_N.length();
        double sum = 0;
        for (int i = 0; i < len_N ; i++) {
            char char_su = str_N.charAt(i);
            int num_su=0;
            if(char_su <= '9'){
                num_su = char_su - '0';
            }else {
                num_su = char_su - 'A' + 10;
            }
            sum += num_su*Math.pow(num_B,(len_N-(i+1)));

        }
        return sum;
    }
}
