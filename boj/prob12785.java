package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob12785 {
    private static int w, h;
    private static int x, y;

    private static final int REMAINDER = 1_000_007;

    public static void main(String[] args) throws NumberFormatException, IOException {
        input();

        System.out.println(dp());
    }

    private static int dp() {
        int[][] dp = new int[w + 1][h + 1];
        dp[0][0] = 1;

        setDpFromAToB(0, 0, x, y, dp);
        setDpFromAToB(x, y, w, h, dp);

        return dp[w][h];
    }

    private static void setDpFromAToB(int fromX, int fromY, int toX, int toY, int[][] dp) {
        for (int i = fromX; i <= toX; i++) {
            for (int j = fromY; j <= toY; j++) {
                if (i == fromX && j == fromY) {
                    continue;
                }
                dp[i][j] += j > 0 ? dp[i][j - 1] : 0;
                dp[i][j] += i > 0 ? dp[i - 1][j] : 0;
                dp[i][j] %= REMAINDER;
            }
        }
    }

    private static void input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken()) - 1;
        h = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken()) - 1;
        y = Integer.parseInt(st.nextToken()) - 1;
    }
}
