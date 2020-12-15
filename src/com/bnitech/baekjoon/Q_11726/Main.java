package com.bnitech.acmicpc.Q_11726;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numN = Integer.parseInt(br.readLine());

        if (numN == 1) {
            System.out.print(1);
            return;
        }

        int[] memoN = new int[numN + 1];
        memoN[1] = 1;
        memoN[2] = 2;
        for (int i = 3; i <= numN; i++) {
            memoN[i] = (memoN[i - 1] + memoN[i - 2])%10007;
        }
        System.out.print(memoN[numN]);
    }
}
