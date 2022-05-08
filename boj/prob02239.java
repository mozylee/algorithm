package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob02239 {
    private static int[][] board;
    private static final int MAX = 9;

    public static void main(String[] args) throws IOException {
        input();
        dfs(0, 0);
    }

    private static void dfs(int row, int col) {
        if (row == MAX) {
            print();
            System.exit(0);
        }
        if (col == MAX) {
            dfs(row + 1, 0);
            return;
        }
        if (board[row][col] > 0) {
            dfs(row, col + 1);
            return;
        }

        for (int value = 1; value <= MAX; value++) {
            boolean flag = true;

            for (int i = 0; i < MAX; i++) {
                if (board[i][col] == value || board[row][i] == value) {
                    flag = false;
                    break;
                }
            }
            if (flag && check(row, col, value)) {
                board[row][col] = value;
                dfs(row, col + 1);
                board[row][col] = 0;
            }
        }
    }

    private static boolean check(int row, int col, int value) {
        int r = (row / 3) * 3;
        int c = (col / 3) * 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (i == row && j == col) {
                    continue;
                }
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void print() {
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[MAX][MAX];
        for (int i = 0; i < MAX; i++) {
            String line = br.readLine();
            for (int j = 0; j < MAX; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
    }
}