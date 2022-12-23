package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class prob02688 {
    private static final int SUM = 10;

    public static void main(String[] args) throws NumberFormatException, IOException {
        long[][] dp = setDpTable();

        StringBuilder sb = new StringBuilder();
        input().stream()
                .forEach(e -> sb.append(dp[e][SUM]).append("\n"));

        System.out.print(sb);
    }

    private static long[][] setDpTable() {
        long[][] dp = new long[64 + 1][SUM + 1];
        Arrays.fill(dp[1], 1);
        dp[1][SUM]=10;
        
        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j < SUM; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }

                dp[i][SUM] += dp[i][j];
            }
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
