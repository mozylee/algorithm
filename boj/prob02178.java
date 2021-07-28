package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class prob02178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static boolean[][] map;
    static boolean[][] visited;
    static String line;
    static Coord now;
    static int nextX, nextY;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    static int bfs() {
        Queue<Coord> queue = new LinkedList<>();
        queue.offer(new Coord(0, 0));

        while (!queue.isEmpty()) {
            now = queue.poll();
            if (now.x == N - 1 && now.y == M - 1)
                return now.distance;
            if (visited[now.x][now.y])
                continue;
            visited[now.x][now.y] = true;
            for (int i = 0; i < dx.length; i++) {
                nextX = now.x + dx[i];
                nextY = now.y + dy[i];
                if (isVaild(nextX, nextY) && map[nextX][nextY])
                    queue.offer(new Coord(nextX, nextY, now.distance + 1));
            }
        }
        return -1;
    }

    static boolean isVaild(int x, int y) {
        return isVaildX(x) && isValidY(y);
    }

    static boolean isVaildX(int x) {
        return x >= 0 && x < N;
    }

    static boolean isValidY(int y) {
        return y >= 0 && y < M;
    }

    static void setNM(String[] nm) {
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
    }

    static void setMap() throws IOException {
        map = new boolean[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '1')
                    map[i][j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        setNM(br.readLine().split(" "));
        setMap();
        System.out.println(bfs());
    }
}

class Coord {
    int x, y;
    int distance;

    Coord(int x, int y) {
        this.x = x;
        this.y = y;
        distance = 1;
    }

    Coord(int x, int y, int d) {
        this(x, y);
        distance = d;
    }
}