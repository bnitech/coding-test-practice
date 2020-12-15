package com.bnitech.acmicpc.Q_11052;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numN = Integer.parseInt(br.readLine());
        int[] memoCost = new int[numN + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        memoCost[1] = Integer.parseInt(st.nextToken());
        for (int n = 2; n <= numN; n++) {
            memoCost[n] = Integer.parseInt(st.nextToken());
            for (int k = 1; k <= n - k; k++) {
                if (memoCost[n] < memoCost[n - k] + memoCost[k]) {
                    memoCost[n] = memoCost[n - k] + memoCost[k];
                }
            }
        }
        System.out.print(memoCost[numN]);
    }
}
