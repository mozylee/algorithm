package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob16441 {
    private static int N, M;

    private static char[][] board;
    private static boolean[][] visited;

    private static final char WOLF = 'W', MOUNTAIN = '#', GRASS = '.', ICE = '+', PIG = 'P';
    private static ArrayList<Point> wolves = new ArrayList<>();

    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        input();

        for (Point wolf : wolves) {
            bfs(wolf.x, wolf.y);
        }

        setPig();
        printBoard();
    }

    private static void bfs(int x, int y) {
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (board[nx][ny] == MOUNTAIN || visited[nx][ny]) {
                    continue;
                }

                if (board[nx][ny] == ICE) {
                    Point endOfIce = getEndOfIce(i, new Point(nx, ny));
                    if (visited[endOfIce.x][endOfIce.y]) {
                        continue;
                    }
                    visited[endOfIce.x][endOfIce.y] = true;
                    queue.add(new Point(endOfIce.x, endOfIce.y));
                } else {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }

    }

    private static Point getEndOfIce(int direction, Point now) {
        int nx = now.x + dx[direction];
        int ny = now.y + dy[direction];

        if (board[now.x][now.y] == GRASS || board[nx][ny] == MOUNTAIN) {
            return now;
        }

        now.x = nx;
        now.y = ny;
        return getEndOfIce(direction, now);
    }

    private static void setPig() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == GRASS && !visited[i][j]) {
                    board[i][j] = PIG;
                }
            }
        }
    }

    private static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == WOLF) {
                    wolves.add(new Point(i, j));
                }
            }
        }
    }

    private static final class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}