package boj;

import java.io.*;
import java.util.StringTokenizer;

public class prob17404 {
    static int[][] dp;
    static int[][] cost;
    static int N;
    static final int MAX_VALUE = (int) 1e7;

    public static void main(String[] args) {
        input();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            setDp(i);
            for (int j = 0; j < 3; j++)
                min = Math.min(min, dp[N - 1][j]);
        }
        System.out.println(min);
    }

    static void setDp(int color) {
        dp = new int[N][3];
        for (int i = 0; i < 3; i++)
            dp[0][i] = MAX_VALUE;
        dp[0][color] = cost[0][color];
        for (int i = 1; i < N; i++)
            for (int j = 0; j < 3; j++) {
                if (i < N - 1 || j != color)
                    dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + cost[i][j];
                else
                    dp[i][j] = MAX_VALUE;
            }
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
