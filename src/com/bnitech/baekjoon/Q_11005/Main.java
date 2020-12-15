/*
수학 - Base Conversion - 진법변환2
 */

package com.bnitech.acmicpc.Q_11005;

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
        int num_N = Integer.parseInt(st.nextToken());
        int num_B = Integer.parseInt(st.nextToken());

        StringBuilder sb_N = new StringBuilder();
        while (num_N > 0) {
            char char_su = (char) (num_N % num_B);
            if (char_su < 10) {
                char_su = (char) (char_su + '0');
            } else {
                char_su = (char) (char_su - 10+'A');
            }
            sb_N.insert(0,char_su);
            num_N /= num_B;
        }
        System.out.println(sb_N.toString());
    }
}
