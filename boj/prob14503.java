package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob14503 {
    static int N, M;
    static int r, c, d;
    static int[][] DIRECTION = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static int[][] map;
    static boolean[][] cleaned;
    static int count;

    public static void main(String[] args) {
        input();
        clean();
        System.out.println(count);
    }

    public static void clean() {
        int check = 0;
        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                count++;
            }
            if (isLeftNotClean()) {
                moveLeft();
                turnLeft();
                check = 0;
            } else if (check < 4) {
                turnLeft();
                check++;
            } else if (canMoveBackward()) {
                moveBack();
                check = 0;
            } else {
                break;
            }
        }
    }

    public static boolean isLeftNotClean() {
        int dx = DIRECTION[getLeft()][0];
        int dy = DIRECTION[getLeft()][1];
        return map[r + dx][c + dy] == 0;
    }

    public static boolean canMoveBackward() {
        int dx = DIRECTION[getBack()][0];
        int dy = DIRECTION[getBack()][1];
        return map[r + dx][c + dy] != 1;
    }

    public static void moveLeft() {
        r += DIRECTION[getLeft()][0];
        c += DIRECTION[getLeft()][1];
    }

    public static int getLeft() {
        return (d + 3) % 4;
    }

    public static void turnLeft() {
        d = (d + 3) % 4;
    }

    public static void moveBack() {
        r += DIRECTION[getBack()][0];
        c += DIRECTION[getBack()][1];
    }

    public static int getBack() {
        return (d + 2) % 4;
    }

    public static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            cleaned = new boolean[N][M];
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }
}
