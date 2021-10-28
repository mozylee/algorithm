package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class prob16954 {
    private static final int SIZE = 8;
    private static boolean[][] board = new boolean[SIZE][SIZE];
    private static Queue<Point> walls = new LinkedList<>();
    private static final Point END = new Point(0, SIZE - 1);

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Trial> queue = new LinkedList<>();
        queue.add(new Trial(SIZE - 1, 0, 0));

        while (!queue.isEmpty()) {
            int time = queue.size();
            for (int k = 0; k < time; k++) {
                Trial now = queue.poll();
                if (!board[now.x][now.y]) {
                    continue;
                }
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int nx = now.x + i;
                        int ny = now.y + j;
                        if (isOOB(nx, ny) || !board[nx][ny]) {
                            continue;
                        }
                        if (nx == END.x && ny == END.y) {
                            return 1;
                        }
                        queue.add(new Trial(nx, ny, now.time + 1));
                    }
                }
            }
            downWall();
        }
        return 0;
    }

    private static void downWall() {
        int size = walls.size();
        for (int i = 0; i < size; i++) {
            Point wall = walls.poll();
            board[wall.x][wall.y] = true;
            if (isOOB(wall.x + 1, wall.y))
                continue;
            walls.add(new Point(wall.x + 1, wall.y));
        }
        Iterator<Point> it = walls.iterator();
        while (it.hasNext()) {
            Point wall = it.next();
            board[wall.x][wall.y] = false;
        }
    }

    private static boolean isOOB(int x, int y) {
        return x < 0 || x >= SIZE || y < 0 || y >= SIZE;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        for (int i = 0; i < SIZE; i++) {
            line = br.readLine();
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = line.charAt(j) == '.';
                if (!board[i][j])
                    walls.add(new Point(i, j));
            }
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Trial extends Point {
        int time;

        Trial(int x, int y, int time) {
            super(x, y);

            this.time = time;
        }
    }
}
