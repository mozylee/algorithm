package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class prob01509 {
    private static String input;
    private static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        int length = input.length();
        dp = new boolean[length + 1][length + 1];
        input = " " + input;

        for (int i = 1; i <= length; i++) {
            dp[i][i] = true;
            if (i > 1 && input.charAt(i) == input.charAt(i - 1))
                dp[i - 1][i] = true;
        }

        for (int i = 2; i < length; i++) {
            for (int j = 1; j <= length - i; j++) {
                if (input.charAt(j) == input.charAt(i + j) && dp[j + 1][i + j - 1])
                    dp[j][i + j] = true;
            }
        }
        int[] answer = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[j][i] && (answer[i] == 0 || answer[i] > answer[j - 1] + 1))
                    answer[i] = answer[j - 1] + 1;
            }
        }
        System.out.println(answer[length]);
    }
}
