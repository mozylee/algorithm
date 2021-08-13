package boj;

import java.io.*;

public class prob01992 {
    static boolean[][] map;
    static int N;

    public static void main(String[] args) {
        input();
        System.out.println(divide(0, 0, N));
    }

    static String divide(int x, int y, int size) {
        boolean criteria = map[x][y];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (criteria != map[x + i][y + j]) {
                    return "(" + divide(x, y, size / 2) + divide(x, y + size / 2, size / 2)
                            + divide(x + size / 2, y, size / 2) + divide(x + size / 2, y + size / 2, size / 2) + ")";
                }
            }
        }
        return criteria ? "1" : "0";
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            map = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = line.charAt(j) == '1';
                }
            }
        } catch (Exception e) {
        }
    }
}
