package boj;

import java.io.*;
import java.util.*;

public class prob14890 {
    static int N, L;
    static int[][] map;

    public static void main(String[] args) {
        input();
        int count = 0;
        for (int i = 0; i < N; i++) {
            count += checkRow(i) ? 1 : 0;
            count += checkColumn(i) ? 1 : 0;
        }
        System.out.println(count);
    }

    public static boolean checkRow(int row) {
        int step = 1;
        int before = map[row][0];
        int skipAmount = 0;
        for (int i = 1; i < N; i++) {
            if (skipAmount > 0) {
                skipAmount--;
                continue;
            }
            if (Math.abs(map[row][i] - before) > 1)
                return false;
            if (map[row][i] > before) {
                if (step < L)
                    return false;
                step = 0;
            } else if (map[row][i] < before) {
                if (!checkNextColumns(row, i))
                    return false;
                step = -1;
                skipAmount = L - 1;
            }
            step++;
            before = map[row][i];
        }
        return true;
    }

    public static boolean checkNextColumns(int row, int before) {
        for (int i = 1; i < L; i++)
            if (before + i >= N || map[row][before + i] != map[row][before])
                return false;
        return true;
    }

    public static boolean checkColumn(int col) {
        int step = 1;
        int before = map[0][col];
        int skipAmount = 0;
        for (int i = 1; i < N; i++) {
            if (skipAmount > 0) {
                skipAmount--;
                continue;
            }
            if (Math.abs(map[i][col] - before) > 1)
                return false;
            if (map[i][col] > before) {
                if (step < L)
                    return false;
                step = 0;
            } else if (map[i][col] < before) {
                if (!checkNextRows(col, i))
                    return false;
                skipAmount = L - 1;
                step = -1;
            }
            step++;
            before = map[i][col];
        }
        return true;
    }

    public static boolean checkNextRows(int col, int before) {
        for (int i = 1; i < L; i++)
            if (before + i >= N || map[before + i][col] != map[before][col])
                return false;
        return true;
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }

    static void printRow(int row) {
        System.out.println("Row " + row);
        for (int i = 0; i < map.length; i++) {
            System.out.print(map[row][i] + " ");
        }
        System.out.println();
    }

    static void printCol(int col) {
        System.out.println("Col " + col);
        for (int i = 0; i < map.length; i++) {
            System.out.print(map[i][col] + " ");
        }
        System.out.println();
    }
}
