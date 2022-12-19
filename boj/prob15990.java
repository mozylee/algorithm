package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class prob15990 {
    private static final int REMAINDER = 1_000_000_009;

    public static void main(String[] args) throws NumberFormatException, IOException {
        List<Integer> cases = input();

        long[][] dp = dp(cases.stream().mapToInt(e -> e).max().orElse(100_000));
        StringBuilder sb = new StringBuilder();
        cases.stream()
                .forEach(e -> sb.append(dp[e][0]).append("\n"));

        System.out.println(sb);
    }

    private static long[][] dp(int N) {
        long[][] dp = new long[N + 1][4];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][2] = 1;
        dp[3][0] = 3;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < dp.length; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j] += dp[i - j][(j + k) % 3 + 1];
                    dp[i][j] %= REMAINDER;
                }
            }

            dp[i][0] = ((dp[i][1] + dp[i][2]) % REMAINDER + dp[i][3]) % REMAINDER;
        }

        return dp;
    }

    private static List<Integer> input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        List<Integer> cases = new ArrayList<>(T);
        for (int i = 0; i < T; i++) {
            cases.add(Integer.parseInt(br.readLine()));
        }
        return cases;
    }
}
