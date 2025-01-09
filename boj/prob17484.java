package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob17484 {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int[][] matrix = getMatrix();

        int result = calculate(matrix);

        System.out.println(result);
    }

    private static int calculate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][][] dp = new int[n][m][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][i][j] = matrix[0][i];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // dp(i,j,0) = min(dp(i-1,j+1,1), dp(i-1,j+1,2)) + n(i,j)
                if (j < m - 1) {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + matrix[i][j];
                } else {
                    dp[i][j][0] = Integer.MAX_VALUE;
                }

                // dp(i,j,1) = min(dp(i-1,j,0),   dp(i-1,j,2))   + n(i,j)
                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + matrix[i][j];

                // dp(i,j,2) = min(dp(i-1,j-1,0), dp(i-1,j-1,1)) + n(i,j)
                if (j > 0) {
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + matrix[i][j];
                } else {
                    dp[i][j][2] = Integer.MAX_VALUE;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(min, dp[n - 1][i][j]);
            }
        }

        return min;
    }

    private static int[][] getMatrix() throws IOException {
        StringTokenizer st = new StringTokenizer(READER.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n + 1][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(READER.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return matrix;
    }

}
