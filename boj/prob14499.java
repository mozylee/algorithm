package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob14499 {
    static StringBuilder sb = new StringBuilder();
    static int N, M, x, y, head = 1;
    static int[][] map;
    static int[] dice = new int[] { 0, 0, 0, 0, 0, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int instructor = Integer.parseInt(st.nextToken()) - 1;
            int nx = x + dx[instructor];
            int ny = y + dy[instructor];
            if (isValid(nx, ny)) {
                move(nx, ny);
                changeDice(instructor);
                sb.append(getHead()).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && y >= 00 && x < N && y < M;
    }

    public static void move(int nx, int ny) {
        x = nx;
        y = ny;
    }

    public static void changeDice(int instructor) {
        rollDice(instructor);
        if (map[x][y] == 0) {
            map[x][y] = getOpposite();
        } else {
            setOpposite(map[x][y]);
            map[x][y] = 0;
        }
    }

    public static void rollDice(int instructor) {
        switch (instructor) {
            case 0:
                swap(3, 5);
                swap(6, 3);
                swap(5, 1);
                break;
            case 1:
                swap(1, 6);
                swap(6, 3);
                swap(5, 1);
                break;
            case 2:
                swap(2, 4);
                swap(1, 2);
                swap(6, 4);
                break;
            case 3:
                swap(1, 6);
                swap(1, 2);
                swap(6, 4);
                break;
        }
    }

    public static void swap(int i, int j) {
        int temp = dice[i];
        dice[i] = dice[j];
        dice[j] = temp;
    }

    public static void setOpposite(int n) {
        dice[6] = n;
    }

    public static int getOpposite() {
        return dice[6];
    }

    public static int getHead() {
        return dice[1];
    }
}
