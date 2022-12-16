package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob17626 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = input();

        System.out.println(dp(N));
    }

    private static int dp(int N) {
        int[] dp = new int[N + 1];
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int j = 1; j <= getSqrt(i); j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j]);
            }
            dp[i]++;
        }

        return dp[N];
    }

    private static int getSqrt(int N) {
        return (int) Math.floor(Math.sqrt(N));
    }

    private static int input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return Integer.parseInt(br.readLine());
    }
}
