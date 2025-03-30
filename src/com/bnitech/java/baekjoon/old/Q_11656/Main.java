package com.bnitech.acmicpc.Q_11656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        int inputLen = sb.length();
        ArrayList<String> strList = new ArrayList<>();
        for (int i = 0; i < inputLen; i++) {
            strList.add(new String(sb.toString()));
            sb.deleteCharAt(0);
        }
        Collections.sort(strList);

        for (String s : strList) {
            System.out.println(s);
        }
    }
}
