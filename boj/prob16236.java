package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob16236 {
    private static int N;
    private static int[][] map;

    private static Fish babyShark;
    private static int fishCount;

    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    private static PriorityQueue<Fish> fishes;

    public static void main(String[] args) throws IOException {
        input();

        int time = 0;
        while (fishCount > 0) {
            int moveTime = bfs();
            if (moveTime < 0) {
                break;
            }
            // 제출 시 주석처리
            print();
            time += moveTime;
        }

        System.out.println(time);
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs() {
        fishes.clear();
        Queue<Fish> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new Fish(babyShark.x, babyShark.y, 0));
        visited[babyShark.x][babyShark.y] = true;

        while (!queue.isEmpty() && fishes.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Fish now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (isOOB(nx, ny) || visited[nx][ny] || map[nx][ny] > babyShark.size) {
                        continue;
                    }
                    visited[nx][ny] = true;

                    if (map[nx][ny] != 0 && map[nx][ny] < babyShark.size) {
                        fishes.add(new Fish(nx, ny, now.size + 1));
                        continue;
                    }

                    queue.add(new Fish(nx, ny, now.size + 1));
                }
            }
        }

        if (fishes.isEmpty()) {
            return -1;
        }

        Fish target = fishes.poll();
        map[babyShark.x][babyShark.y] = 0;
        babyShark.move(target.x, target.y);
        map[babyShark.x][babyShark.y] = 9;
        babyShark.eat();
        fishCount--;
        return target.size;
    }

    private static boolean isOOB(int nx, int ny) {
        return 0 > nx || N <= nx || 0 > ny || N <= ny;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) {
                    continue;
                }

                if (map[i][j] == 9) {
                    babyShark = new Fish(i, j, 2);
                    continue;
                }

                fishCount++;
            }
        }

        fishes = new PriorityQueue<>(new Comparator<Fish>() {
            @Override
            public int compare(Fish f1, Fish f2) {
                if (f1.x == f2.x) {
                    return Integer.compare(f1.y, f2.y);
                }
                return Integer.compare(f1.x, f2.x);
            }
        });
    }

    private static class Fish {
        int x, y;
        int size;
        int count;

        Fish(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        void move(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void eat() {
            this.count++;
            if (this.count == this.size) {
                this.size++;
                count = 0;
            }
        }

        @Override
        public String toString() {
            return "[(" + x + "," + y + ") : " + size + "(" + count + ")]";
        }
    }
}
