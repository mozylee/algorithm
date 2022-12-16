package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob17212 {
    private enum Coin {
        ONE(1),
        TWO(2),
        FIVE(5),
        SEVEN(7);

        private int value;

        Coin(int value) {
            this.value = value;
        }
    }

    private static final int MAX_VALUE = 100_000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = input();

        System.out.println(dp(N));
    }

    private static int dp(int N) {
        int[] dp = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            dp[i] = MAX_VALUE;

            for (Coin c : Coin.values()) {
                if (i < c.value) {
                    continue;
                }

                dp[i] = Math.min(dp[i], dp[i - c.value]);
            }
            dp[i]++;
        }

        return dp[N];
    }

    private static int input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return Integer.parseInt(br.readLine());
    }
}
