package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob01022 {
    private static int r1, c1, r2, c2;
    private static int SIZE;
    private static int max;

    private static int[][] board;

    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        input();

        setBoard();

        print();
    }

    private static void setBoard() {
        r1 += SIZE / 2;
        r2 += SIZE / 2;
        c1 += SIZE / 2;
        c2 += SIZE / 2;
        board = new int[r2 - r1 + 1][c2 - c1 + 1];
        int num = SIZE * SIZE;
        int d = 0;
        int i = SIZE - 1, j = SIZE;
        int length = SIZE - 1;
        for (int k = 0; k < SIZE; k++) {
            i += dy[d % 4];
            j += dx[d % 4];
            if (isVaild(i, j)) {
                board[i - r1][j - c1] = num;
                max = Math.max(max, num);
            }
            num--;
        }
        d++;

        while (num > 0) {
            for (int k = 0; k < 2; k++) {
                for (int l = 0; l < length; l++) {
                    i += dy[d % 4];
                    j += dx[d % 4];
                    if (isVaild(i, j)) {
                        board[i - r1][j - c1] = num;
                        max = Math.max(max, num);
                    }
                    num--;
                }
                d++;
            }
            length--;
        }
    }

    private static boolean isVaild(int i, int j) {
        return i >= r1 && i <= r2 && j >= c1 && j <= c2;
    }

    private static void print() {
        int length = 0;
        while (max > 0) {
            length++;
            max /= 10;
        }
        
        int r = r2 - r1;
        int c = c2 - c1;
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                System.out.format("%" + length + "d ", board[i][j]);
            }
            System.out.print(i < r ? "\n" : "");
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        SIZE = getMAX(r1, c1, r2, c2);
        br.close();
    }

    private static int getMAX(int n1, int n2, int n3, int n4) {
        int max = Math.max(Math.abs(n1), Math.abs(n2));
        max = Math.max(max, Math.abs(n3));
        max = Math.max(max, Math.abs(n4));
        max *= 2;
        max += max % 2 == 0 ? 1 : 0;
        return max;
    }

}
