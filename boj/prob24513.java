package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob24513 {
    private static int N, M;
    private static int one = 1, two = 1, three;
    private static final int VACCINE = -1, ONE = 1, TWO = 2, THREE = 3;

    private static int[][] map;
    private static int[][] visited;
    private static Queue<Trial> virus = new LinkedList<>();

    private static final int[] dx = { 0, 0, -1, 1 };
    private static final int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        System.out.println(one + " " + two + " " + three);
    }

    private static void bfs() {
        int length;
        while (!virus.isEmpty()) {
            length = virus.size();
            for (int i = 0; i < length; i++) {
                Trial now = virus.poll();
                if (map[now.x][now.y] == THREE) {
                    continue;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if (cantAffect(now, nx, ny)) {
                        continue;
                    }

                    if (now.virus == ONE) {
                        map[nx][ny] = ONE;
                        visited[nx][ny] = now.time + 1;
                        one++;
                        virus.add(new Trial(nx, ny, now.virus, now.time + 1));
                        continue;
                    }

                    if (now.virus == TWO && map[nx][ny] == ONE && visited[nx][ny] == now.time + 1) {
                        map[nx][ny] = THREE;
                        one--;
                        three++;
                        continue;
                    }

                    map[nx][ny] = TWO;
                    visited[nx][ny] = now.time + 1;
                    two++;
                    virus.add(new Trial(nx, ny, now.virus, now.time + 1));
                }
            }
        }
    }

    private static boolean cantAffect(Trial now, int nx, int ny) {
        return isOOB(nx, ny) || map[nx][ny] == VACCINE || map[nx][ny] == THREE || map[nx][ny] == map[now.x][now.y]
                || visited[nx][ny] <= now.time;
    }

    private static boolean isOOB(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(visited[i], Integer.MAX_VALUE);
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == ONE || map[i][j] == TWO) {
                    virus.add(new Trial(i, j, map[i][j], 1));
                    visited[i][j] = 1;
                }
            }
        }
        if (virus.peek().virus == TWO) {
            virus.add(virus.poll());
        }
    }

    private static final class Trial {
        int x, y, virus, time;

        Trial(int x, int y, int virus, int time) {
            this.x = x;
            this.y = y;
            this.virus = virus;
            this.time = time;
        }
    }
}