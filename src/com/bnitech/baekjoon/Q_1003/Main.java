package Q_1003;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_T = Integer.parseInt(br.readLine());

        for (int i = 0; i < num_T; i++) {
            int num_N = Integer.parseInt(br.readLine());
            int memo[][] = new int[num_N+1][3];
            for (int j = 0; j < num_N; j++) {
                memo[j][0] = -1;
            }

            fibo(num_N, memo);

            System.out.println(memo[num_N][1] + " " + memo[num_N][2]);

        }
    }


    public static int fibo(int N, int[][] memo) {
        if (N == 0) {
            memo[N][1]++;
            return 0;
        }
        if (N == 1) {
            memo[N][2]++;
            return 1;
        }

        if (memo[N - 1][0] == -1) memo[N - 1][0] = fibo(N - 1, memo);
        if (memo[N - 2][0] == -1) memo[N - 2][0] = fibo(N - 2, memo);

        memo[N][1] = memo[N - 1][1] + memo[N - 2][1];
        memo[N][2] = memo[N - 1][2] + memo[N - 2][2];

        return memo[N - 1][0] + memo[N - 2][0];
    }
}
