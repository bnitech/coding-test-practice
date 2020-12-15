/*
수학
GCD : Greatest Common Divisor, LCM : Least Common Multiple
최대공약수와 최소공배수
 */

package com.bnitech.acmicpc.Q_2609;

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

        int numA = Integer.parseInt(st.nextToken());
        int numB = Integer.parseInt(st.nextToken());
        int GCD = findGCD(numA,numB);
        int LCM = (numA*numB)/GCD;

        System.out.println(GCD);
        System.out.println(LCM);
    }

    public int findGCD(int numA, int numB) {
        while (numB != 0) {
            int numR = numA % numB;
            numA = numB;
            numB = numR;
        }
        return numA;
    }
}
