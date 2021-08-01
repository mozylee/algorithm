package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob10830 {
    static int N;
    static long B;
    static final int MOD = 1000;
    static int[][] matrix;
    static int[][] origin;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        matrix = new int[N][N];
        origin = new int[N][];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
            origin[i] = Arrays.copyOf(matrix[i], N);
        }
        for (int[] line : recursive(matrix, B)) {
            for (int num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int[][] recursive(int[][] A, Long exp) {
        if (exp <= 1)
            return A;
        int[][] matrix = recursive(A, exp / 2);
        matrix = multiply(matrix, matrix);
        if (exp % 2 == 1)
            matrix = multiply(matrix, origin);
        return matrix;
    }

    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] += matrix1[j][i] * matrix2[i][k];
                    matrix[j][k] %= MOD;
                }
            }
        }
        return matrix;
    }
}
