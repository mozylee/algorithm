package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob02749 {
    static long N;
    static final int MOD = 1000000;
    static int result = 1;
    static long[][] origin = { { 1, 1 }, { 1, 0 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        long[][] A = { { 1, 1 }, { 1, 0 } };
        System.out.println(recursive(A, N - 1)[0][0]);
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
