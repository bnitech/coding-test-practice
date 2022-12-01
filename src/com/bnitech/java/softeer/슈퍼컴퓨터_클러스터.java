package com.bnitech.java.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 슈퍼컴퓨터_클러스터 {

    static public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String first = reader.readLine();
        String[] firstArr = first.split(" ");
        int N = Integer.parseInt(firstArr[0]);
        int B = Integer.parseInt(firstArr[1]);

        String second = reader.readLine();
        String[] secondArr = second.split(" ");
        List<Integer> comList = Stream.of(secondArr).map(Integer::parseInt).sorted().collect(Collectors.toList());

        long result = 0;
        long min = comList.get(0);
        long max = comList.get(N - 1) + (long) Math.sqrt(B);

        for (long i = min; i <= max; i++) {
            double sum = 0;
            for (int n : comList) {
                if (n > i) {
                    break;
                }

                sum += Math.pow(i - n, 2);
            }

            if (sum > B) {
                break;
            }

            result = i;
        }

        System.out.println(result);
    }
}
