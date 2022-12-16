package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob13699 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = input();

        System.out.println(dp(N));
    }

    private static long dp(int N) {
        long[] t = new long[N + 1];
        t[0] = 1L;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                t[i] += t[j] * t[i - j - 1];
            }
        }

        return t[N];
    }

    private static int input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return Integer.parseInt(br.readLine());
    }
}
