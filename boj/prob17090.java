package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob17090 {
    private static int N, M;

    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    private static int[][] maze;
    private static boolean[][] visited;
    private static boolean[][] escaped;

    public static void main(String[] args) throws IOException {
        input();
        visited = new boolean[N][M];
        escaped = new boolean[N][M];

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    continue;
                }
                count += dfs(i, j);
            }
        }
        System.out.println(count);
    }

    private static int dfs(int i, int j) {
        int direction = maze[i][j];
        int nx = i + dx[direction];
        int ny = j + dy[direction];
        visited[i][j] = true;
        if (canEscape(nx, ny) || escaped[nx][ny]) {
            escaped[i][j] = true;
            return 1;
        }

        if (visited[nx][ny]) {
            return escaped[nx][ny] ? 1 : 0;
        }

        int done = dfs(nx, ny);
        escaped[i][j] = escaped[nx][ny];
        done += escaped[i][j] ? 1 : 0;
        return done;
    }

    private static boolean canEscape(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];

        String line;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < M; j++) {
                int value = -1;
                switch (line.charAt(j)) {
                    case 'U':
                        value = 0;
                        break;
                    case 'R':
                        value = 1;
                        break;
                    case 'D':
                        value = 2;
                        break;
                    case 'L':
                        value = 3;
                        break;
                }
                maze[i][j] = value;
            }
        }
    }
}
