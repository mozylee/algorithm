package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob13459 {
    static int N, M;
    static final int MAX_TIME = 10;
    static Point red, blue, HOLE;
    static boolean[][] board;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(bfs() ? 1 : 0);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        board = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'R') {
                    red = new Point(i, j);
                } else if (line.charAt(j) == 'B') {
                    blue = new Point(i, j);
                } else if (line.charAt(j) == 'O') {
                    HOLE = new Point(i, j);
                }
                board[i][j] = line.charAt(j) != '#';
            }
        }
    }

    private static boolean bfs() {
        Queue<Trial> queue = new LinkedList<>();
        queue.add(new Trial(red, blue, 0));
        HashSet<Integer> visited = new HashSet<>();
        visited.add(queue.peek().hashCode());
        while (!queue.isEmpty()) {
            Trial now = queue.poll();
            for (int i = 0; i < 4; i++) {
                Trial next = move(now, i);
                if (next.time > MAX_TIME) {
                    continue;
                }
                if (next.blue.equals(HOLE)) {
                    continue;
                }
                if (next.red.equals(HOLE)) {
                    return true;
                }
                if (visited.contains(next.hashCode())) {
                    continue;
                }
                visited.add(next.hashCode());
                queue.add(next);
            }
        }
        return false;
    }

    private static Trial move(Trial t, int d) {
        Point nextRed, nextBlue;
        switch (d) {
            case 0:
                if (t.red.y < t.blue.y) {
                    nextRed = movePoint(t.red, d);
                    if (!nextRed.equals(HOLE)) {
                        board[nextRed.x][nextRed.y] = false;
                    }
                    nextBlue = movePoint(t.blue, d);
                    board[nextRed.x][nextRed.y] = true;
                } else {
                    nextBlue = movePoint(t.blue, d);
                    if (!nextBlue.equals(HOLE))
                        board[nextBlue.x][nextBlue.y] = false;
                    nextRed = movePoint(t.red, d);
                    board[nextBlue.x][nextBlue.y] = true;
                }
                return new Trial(nextRed, nextBlue, t.time + 1);
            case 1:
                if (t.red.y > t.blue.y) {
                    nextRed = movePoint(t.red, d);
                    if (!nextRed.equals(HOLE))
                        board[nextRed.x][nextRed.y] = false;
                    nextBlue = movePoint(t.blue, d);
                    board[nextRed.x][nextRed.y] = true;
                } else {
                    nextBlue = movePoint(t.blue, d);
                    if (!nextBlue.equals(HOLE))
                        board[nextBlue.x][nextBlue.y] = false;
                    nextRed = movePoint(t.red, d);
                    board[nextBlue.x][nextBlue.y] = true;
                }
                return new Trial(nextRed, nextBlue, t.time + 1);
            case 2:
                if (t.red.x < t.blue.x) {
                    nextRed = movePoint(t.red, d);
                    if (!nextRed.equals(HOLE))
                        board[nextRed.x][nextRed.y] = false;
                    nextBlue = movePoint(t.blue, d);
                    board[nextRed.x][nextRed.y] = true;
                } else {
                    nextBlue = movePoint(t.blue, d);
                    if (!nextBlue.equals(HOLE))
                        board[nextBlue.x][nextBlue.y] = false;
                    nextRed = movePoint(t.red, d);
                    board[nextBlue.x][nextBlue.y] = true;
                }
                return new Trial(nextRed, nextBlue, t.time + 1);
            case 3:
                if (t.red.x > t.blue.x) {
                    nextRed = movePoint(t.red, d);
                    if (!nextRed.equals(HOLE))
                        board[nextRed.x][nextRed.y] = false;
                    nextBlue = movePoint(t.blue, d);
                    board[nextRed.x][nextRed.y] = true;
                } else {
                    nextBlue = movePoint(t.blue, d);
                    if (!nextBlue.equals(HOLE))
                        board[nextBlue.x][nextBlue.y] = false;
                    nextRed = movePoint(t.red, d);
                    board[nextBlue.x][nextBlue.y] = true;
                }
                return new Trial(nextRed, nextBlue, t.time + 1);
        }
        return null;
    }

    private static Point movePoint(Point p, int i) {
        int x = p.x;
        int y = p.y;
        while (!isOOB(x + dx[i], y + dy[i]) && board[x + dx[i]][y + dy[i]]) {
            x += dx[i];
            y += dy[i];
            if (x == HOLE.x && y == HOLE.y) {
                break;
            }
        }
        return new Point(x, y);
    }

    private static boolean isOOB(int x, int y) {
        return x < 0 && x >= N && y < 0 && y >= M;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return 100 * x + y;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) {
                return false;
            }

            Point p = (Point) obj;
            return this.x == p.x && this.y == p.y;
        }
    }

    static class Trial {
        Point red, blue;
        int time;

        Trial(Point red, Point blue, int time) {
            this.red = red;
            this.blue = blue;
            this.time = time;
        }

        @Override
        public int hashCode() {
            return red.hashCode() * 10000 + blue.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) {
                return false;
            }

            Trial t = (Trial) obj;
            return this.red.equals(t.red) && this.blue.equals(t.blue);
        }
    }
}