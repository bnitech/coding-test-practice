/*
?????? - Modular Arithmetic - ???머�?
 */

package com.bnitech.java.baekjoon.old.Q_10430;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws Exception{
//        new Main().result();
    }
    public void result() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numA = Integer.parseInt(st.nextToken());
        int numB = Integer.parseInt(st.nextToken());
        int numC = Integer.parseInt(st.nextToken());

        System.out.println((numA+numB)%numC);
        System.out.println((numA%numC+numB%numC)%numC);
        System.out.println((numA*numB)%numC);
        System.out.println((numA%numC*numB%numC)%numC);
    }

}
