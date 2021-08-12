package boj;

import java.io.*;
import java.util.StringTokenizer;

public class prob01149 {
    static int[][] dp;
    static int[][] cost;
    static int N;

    public static void main(String[] args) {
        input();
        setDp();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++)
            min = Math.min(min, dp[N - 1][i]);
        System.out.println(min);
    }

    static void setDp() {
        dp = new int[N][3];
        for (int i = 0; i < 3; i++)
            dp[0][i] = cost[0][i];
        for (int i = 1; i < N; i++)
            for (int j = 0; j < 3; j++)
                dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + cost[i][j];
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            cost = new int[N][3];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++)
                    cost[i][j] = Integer.parseInt(st.nextToken());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
