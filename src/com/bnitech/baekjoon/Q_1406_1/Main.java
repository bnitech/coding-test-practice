package com.bnitech.acmicpc.Q_1406_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {

        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack stackL = new Stack();
        Stack stackR = new Stack();
        for (char c : br.readLine().toCharArray()) {
            stackL.push(c);
        }
        int line = Integer.parseInt(br.readLine());
        while (line-- > 0) {
            String str = br.readLine();
            switch (str.charAt(0)) {
                case 'L': {
                    if (!stackL.empty()) stackR.push(stackL.pop());
                    break;
                }
                case 'D': {
                    if (!stackR.empty()) stackL.push(stackR.pop());
                    break;
                }
                case 'B': {
                    if (!stackL.empty()) stackL.pop();
                    break;
                }
                case 'P': {
                    if(str.length()>=3) stackL.push(str.charAt(2));
                    break;
                }
                default: {
                    System.out.println("ERROR");
                    break;
                }
            }
        }
        while (!stackL.empty()) {
            stackR.push(stackL.pop());
        }
        int size = stackR.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stackR.pop());
        }
    }
}
