package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob17829 {
    private static int[][] board;

    public static void main(String[] args) {
        input();
        System.out.println(pool(0, 0, board.length));
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try {
            int N = Integer.valueOf(br.readLine());
            board = new int[N][N];
            for (int i = 0; i < board.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < board.length; j++) {
                    board[i][j] = Integer.valueOf(st.nextToken());
                }
            }
        } catch (Exception e) {
            System.out.println("INPUT ERROR!!!!");
        }

    }

    private static int pool(int x, int y, int size) {
        if (size == 1) {
            return board[x][y];
        }
        int half = size / 2;
        int[] pooling = { pool(x, y, half),
                pool(x, y + half, half),
                pool(x + half, y, half),
                pool(x + half, y + half, half) };
        return getSecondaryBigNumber(pooling);
    }

    private static int getSecondaryBigNumber(int[] arr) {
        Arrays.sort(arr);
        return arr[2];
    }
}
