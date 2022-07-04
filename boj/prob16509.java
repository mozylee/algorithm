package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob16509 {
    private static final int R = 9, C = 8;

    private static int R1, C1, R2, C2;
    private static int[] dx = { -3, -3, -2, 2, 3, 3, 2, -2 };
    private static int[] dy = { -2, 2, 3, 3, 2, -2, -3, -3 };
    private static int[] ddx = { -2, -2, -1, 1, 2, 2, 1, -1 };
    private static int[] ddy = { -1, 1, 2, 2, 1, -1, -2, -2 };
    private static int[] dddx = { -1, 0, 1, 0 };
    private static int[] dddy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(bfs());
    }

    private static int bfs() {
        boolean[][] visited = new boolean[R + 1][C + 1];
        visited[R1][C1] = true;

        Queue<Trial> queue = new LinkedList<>();
        queue.add(new Trial(R1, C1, 0));

        while (!queue.isEmpty()) {
            Trial now = queue.poll();

            for (int i = 0; i < C; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int _nx = now.x + ddx[i];
                int _ny = now.y + ddy[i];
                int __nx = now.x + dddx[i / 2];
                int __ny = now.y + dddy[i / 2];

                if (isKing(_nx, _ny) || isKing(__nx, __ny) || isOOB(nx, ny) || visited[nx][ny]) {
                    continue;
                }
                if (nx == R2 && ny == C2) {
                    return now.time + 1;
                }
                visited[nx][ny] = true;
                queue.add(new Trial(nx, ny, now.time + 1));
            }
        }

        return -1;
    }

    private static boolean isKing(int x, int y) {
        return x == R2 && y == C2;
    }

    private static boolean isOOB(int nx, int ny) {
        return nx < 0 || nx > R || ny < 0 || ny > C;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R1 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        R2 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());
    }

    private static final class Trial {
        int x, y, time;

        Trial(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
