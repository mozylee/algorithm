package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob01535 {
    private static int N;
    private static int[] health, pleasure;

    private static final int MAX_HEALTH = 100;

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(dp());
    }

    private static int dp() {
        int[][] dp = new int[N + 1][MAX_HEALTH + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < MAX_HEALTH; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], health[i] < j
                        ? (dp[i - 1][j - health[i]] + pleasure[i])
                        : 0);
            }
        }

        return Arrays.stream(dp[N]).max().orElse(0);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        health = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        pleasure = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            pleasure[i] = Integer.parseInt(st.nextToken());
        }
    }
}
