package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob02086 {
    static long a, b;
    static final long MOD = 1000000000;
    static long[][] origin = { { 1, 1 }, { 1, 0 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        long[][] matrix = { { 1, 1 }, { 1, 0 } };
        System.out.println((recursive(matrix, b + 1)[0][0] - recursive(matrix, a)[0][0] + MOD) % MOD);
    }

    public static long[][] recursive(long[][] A, long exp) {
        if (exp <= 1)
            return A;
        long[][] matrix = recursive(A, exp / 2);
        matrix = multiply(matrix, matrix);
        if (exp % 2 == 1)
            matrix = multiply(matrix, origin);
        return matrix;
    }

    public static long[][] multiply(long[][] matrix1, long[][] matrix2) {
        long[][] matrix = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    matrix[j][k] += matrix1[j][i] * matrix2[i][k];
                    matrix[j][k] %= MOD;
                }
            }
        }
        return matrix;
    }
}
