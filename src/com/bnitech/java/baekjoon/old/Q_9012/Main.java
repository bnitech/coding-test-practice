package com.bnitech.acmicpc.Q_9012;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        new Main().result();
    }

    public void result() {
        Scanner input = new Scanner(System.in);
        int testCase = input.nextInt();
        Stack<Character> stack = null;
        char[] chars = null;
        String output = null;
        for (int t = 1; t <= testCase; t++) {
            stack = new Stack<>();
            chars = input.next().toCharArray();
            output = "YES";
            for (char c:chars){
                if (c == '(') {
                    stack.push('(');
                } else if (c == ')') {
                    if (stack.empty()) {
                        output = "NO";
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(!stack.empty()) output = "NO";
            System.out.println(output);

        }
    }
}
