package boj;

import java.io.*;
import java.util.StringTokenizer;

public class prob02096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] dpMax = new int[2][3];
        int[][] dpMin = new int[2][3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int value = Integer.parseInt(st.nextToken());
            dpMin[0][i] = dpMax[0][i] = value;
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                int value = Integer.parseInt(st.nextToken());
                dpMax[1][j] = dpMin[1][j] = value;
                for (int k = j - 1; k <= j + 1; k++) {
                    if (k < 0 || k > 2)
                        continue;
                    max = Math.max(max, dpMax[0][k]);
                    min = Math.min(min, dpMin[0][k]);
                }
                dpMax[1][j] = max + value;
                dpMin[1][j] = min + value;
            }
            for (int j = 0; j < 3; j++) {
                dpMax[0][j] = dpMax[1][j];
                dpMin[0][j] = dpMin[1][j];
            }
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, dpMax[0][i]);
            min = Math.min(min, dpMin[0][i]);
        }
        System.out.println(max + " " + min);
    }
}