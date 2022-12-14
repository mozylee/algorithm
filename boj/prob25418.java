package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob25418 {
    private static int A, K;

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(dp());
    }

    private static int dp() {
        int[] dp = new int[K + 1];

        for (int i = A + 1; i <= K; i++) {
            dp[i] = 1 + (i % 2 == 0 && i / 2 >= A
                    ? Math.min(dp[i - 1], dp[i / 2])
                    : dp[i - 1]);
        }

        return dp[K];
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}
