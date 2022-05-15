package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob01580 {
    private static int N, M;
    private static boolean[][] board;
    private static Point initialA, initialB;

    private static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1, 0 };
    private static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Trial> queue = new LinkedList<>();
        queue.add(new Trial(initialA, initialB, 0));
        HashSet<Integer> visited = new HashSet<>();
        visited.add(getHashCode(initialA.x, initialA.y, initialB.x, initialB.y));

        while (!queue.isEmpty()) {
            Trial now = queue.poll();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int Ax = now.A.x + dx[i];
                    int Ay = now.A.y + dy[i];
                    int Bx = now.B.x + dx[j];
                    int By = now.B.y + dy[j];

                    if (isOOB(Ax, Ay, Bx, By) || isWall(Ax, Ay, Bx, By)) {
                        continue;
                    }

                    if (visited.contains(getHashCode(Ax, Ay, Bx, By))) {
                        continue;
                    }

                    Point A = new Point(Ax, Ay);
                    Point B = new Point(Bx, By);

                    if (A.equals(now.B) && B.equals(now.A)) {
                        continue;
                    }

                    if (A.equals(B)) {
                        continue;
                    }

                    visited.add(getHashCode(Ax, Ay, Bx, By));
                    if (A.equals(initialB) && B.equals(initialA)) {
                        return now.count + 1;
                    }

                    queue.add(new Trial(A, B, now.count + 1));
                }
            }
        }

        return -1;
    }

    private static boolean isWall(int Ax, int Ay, int Bx, int By) {
        return !board[Ax][Ay] || !board[Bx][By];
    }

    private static boolean isOOB(int Ax, int Ay, int Bx, int By) {
        return isOOB(Ax, Ay) || isOOB(Bx, By);
    }

    private static boolean isOOB(int x, int y) {
        return x >= N || x < 0 || y >= M || y < 0;
    }

    private static int getHashCode(int x1, int y1, int x2, int y2) {
        int code = 0;
        int hash = 1;

        code += x1 * hash;
        hash *= 21;
        code += y1 * hash;
        hash *= 21;
        code += x2 * hash;
        hash *= 21;
        code += y2 * hash;
        return code;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) != 'X';
                if (line.charAt(j) == 'A') {
                    initialA = new Point(i, j);
                }

                if (line.charAt(j) == 'B') {
                    initialB = new Point(i, j);
                }
            }
        }
    }

    private static final class Trial {
        Point A;
        Point B;
        int count;

        Trial(Point A, Point B, int count) {
            this.A = A;
            this.B = B;
            this.count = count;
        }

        @Override
        public String toString() {
            return "{" + "A : " + A + ", B : " + B + " = " + count + "}";
        }
    }

    private static final class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point p = (Point) obj;
                return this.x == p.x && this.y == p.y;
            }
            return super.equals(obj);
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}
