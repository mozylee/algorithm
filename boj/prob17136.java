package boj;

import java.io.*;
import java.util.StringTokenizer;

public class prob17136 {
    static boolean[][] board = new boolean[10][10];
    static int[] paperAmounts = { 0, 5, 5, 5, 5, 5 };
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        input();
        dfs(0, 0, 0);
        System.out.println(min < Integer.MAX_VALUE ? min : -1);
    }

    static void dfs(int x, int y, int count) {
        if (x >= 9 && y > 9) {
            min = Math.min(min, count);
            return;
        }
        if (count >= min) {
            return;
        }
        if (y > 9) {
            dfs(x + 1, 0, count);
            return;
        }
        if (board[x][y]) {
            for (int size = 5; size > 0; size--) {
                if (paperAmounts[size] <= 0 || !canAttach(x, y, size)) {
                    continue;
                }
                attach(x, y, size);
                paperAmounts[size]--;
                dfs(x, y + 1, count + 1);
                attach(x, y, size);
                paperAmounts[size]++;
            }
        } else {
            dfs(x, y + 1, count);
        }
    }

    static void attach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                board[i][j] = !board[i][j];
            }
        }
    }

    static boolean canAttach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (i > 9 || j > 9 || !board[i][j])
                    return false;
            }
        }
        return true;
    }

    static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try {
            for (int i = 0; i < 10; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 10; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken()) == 1;
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }
}
