package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob02502 {
    private static int D, K;

    private static final int MAX_VALUE = 100_000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        input();

        for (int i = 1; i <= MAX_VALUE; i++) {
            for (int j = i; j <= MAX_VALUE; j++) {
                if (!dp(i, j)) {
                    continue;
                }

                System.out.println(i + "\n" + j);
                return;
            }
        }
    }

    private static boolean dp(int A, int B) {
        int[] dp = new int[D + 3];
        dp[1] = A;
        dp[2] = B;

        for (int i = 3; i <= D; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[D] == K;
    }

    private static void input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}
