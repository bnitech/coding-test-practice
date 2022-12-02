package com.bnitech.java.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 통근버스_출발_순서_검증하기 {
    public static void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 3 ≤ N ≤ 5,000
        int N = Integer.parseInt(reader.readLine());
        List<Integer> list = Stream.of(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());


        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (!isOk(list.get(i), list.get(j), list.get(k))) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    public static boolean isOk(int a, int b, int c) {
        int min = Math.min(a, Math.min(b, c));
        if (a == min) {
            return true;
        } else {
            if (b == min) {
                return true;
            } else {
                return a >= b;
            }
        }
    }
}
