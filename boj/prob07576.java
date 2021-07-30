package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob07576 {
    static int n, m, sum, tomato, nextX, nextY, length;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int[][] tomatoes;
    static Point now;

    static Queue<Point> queue = new LinkedList<>();

    public static int bfs() {
        int time = 0;
        while (sum > 0) {
            length = queue.size();
            if (length == 0)
                return -1;
            Outter: while (length > 0) {
                now = queue.poll();
                for (int i = 0; i < 4; i++) {
                    nextX = now.x + dx[i];
                    nextY = now.y + dy[i];
                    if (isValid(nextX, nextY) && tomatoes[nextX][nextY] == 0) {
                        sum--;
                        if (sum == 0) {
                            break Outter;
                        }
                        tomatoes[nextX][nextY] = 1;
                        queue.offer(new Point(nextX, nextY));
                    }
                }
                length--;
            }
            time++;
        }
        return time;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sum = n * m;
        tomatoes = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                tomato = Integer.parseInt(st.nextToken());
                sum = tomato == 0 ? sum : sum - 1;
                tomatoes[i][j] = tomato;
                if (tomato == 1)
                    queue.offer(new Point(i, j));
            }
        }
        System.out.println(bfs());

    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
