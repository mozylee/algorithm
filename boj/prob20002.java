package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob20002 {
    private static int N;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[][] farm = input();
        int[][] acc = accumulate(farm);
        setPartialMax(acc);
        System.out.println(max);
    }

    private static void setPartialMax(int[][] acc) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = N - 1; k > 0; k--) {
                    if (i + k >= N || j + k >= N)
                        continue;
                    max = Math.max(max, getPartialSum(acc, i, j, k));
                }
            }
        }
    }

    private static int getPartialSum(int[][] acc, int i, int j, int k) {
        int ret = acc[i + k][j + k];
        ret -= (i - 1 >= 0) ? acc[i - 1][j + k] : 0;
        ret -= (j - 1 >= 0) ? acc[i + k][j - 1] : 0;
        ret += (i - 1 >= 0) && (j - 1 >= 0) ? acc[i - 1][j - 1] : 0;
        return ret;
    }

    private static int[][] accumulate(int[][] farm) {
        int[][] acculation = new int[N][N];
        acculation[0][0] = farm[0][0];
        for (int i = 1; i < N; i++) {
            acculation[0][i] += farm[0][i] + acculation[0][i - 1];
            acculation[i][0] += farm[i][0] + acculation[i - 1][0];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                acculation[i][j] = farm[i][j] + acculation[i - 1][j] + acculation[i][j - 1] - acculation[i - 1][j - 1];
            }
        }
        return acculation;
    }

    private static int[][] input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] farm = null;
        StringTokenizer st;
        try {
            N = Integer.valueOf(br.readLine());
            farm = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    farm[i][j] = Integer.valueOf(st.nextToken());
                    max = Math.max(max, farm[i][j]);
                }
            }
        } catch (Exception e) {
            System.out.println("INPUT ERROR!!!");
        }
        return farm;
    }
}
