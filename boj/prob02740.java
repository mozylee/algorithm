package boj;

import java.io.*;
import java.util.StringTokenizer;

public class prob02740 {
    static int N, M, K;
    static int[][] A, B;

    public static void main(String[] args) {
        input();
        int[][] AB = multiplyMatrixes(A, B);
        print(AB);
    }

    static int[][] multiplyMatrixes(int[][] A, int[][] B) {
        int[][] result = new int[N][K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                int temp = 0;
                for (int k = 0; k < M; k++) {
                    temp += A[i][k] * B[k][j];
                }
                result[i][j] = temp;
            }
        }
        return result;
    }

    static void print(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int element : row) {
                sb.append(element + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            B = new int[M][K];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < K; j++) {
                    B[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
