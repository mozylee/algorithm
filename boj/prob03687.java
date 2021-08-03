package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob03687 {
    static StringBuilder sb = new StringBuilder();
    static long[] dpMin = new long[100 + 1];
    static int[] min = { 0, 0, 1, 7, 4, 2, 0, 8, 10 };

    static void calculateMin() {
        for (int i = 2; i < 9; i++) {
            dpMin[i] = min[i];
        }
        dpMin[6] = 6;
        for (int i = 9; i < 101; i++) {
            dpMin[i] = Long.MAX_VALUE;
            for (int j = 2; j <= 7; j++) {
                dpMin[i] = Math.min(dpMin[i], dpMin[i - j] * 10 + min[j]);
            }
        }
    }

    static void calculateMax(int n) {
        if (n % 2 == 1) {
            sb.append(7);
            n -= 3;
        }
        while (n > 0) {
            sb.append(1);
            n -= 2;
        }
    }

    static void calculate(int n) {
        sb.append(dpMin[n]);
        sb.append(' ');
        calculateMax(n);
        sb.append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        calculateMin();
        for (int i = 0; i < n; i++)
            calculate(Integer.parseInt(br.readLine()));
        System.out.println(sb);
    }
}
