package com.bnitech.acmicpc.Q_11654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        new Main().result(br.readLine());
    }

    public void result(String input) {
        char value = input.charAt(0);
        System.out.println((int)value);
    }
}
