package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class prob02667 {
    static int N;
    static boolean[][] map;
    static ArrayList<Integer> areas = new ArrayList<>();
    static XY now;
    static int nextX, nextY;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static StringBuilder sb = new StringBuilder();

    static void bfs(int x, int y) {
        Queue<XY> queue = new LinkedList<>();
        queue.offer(new XY(x, y));
        map[x][y] = false;
        int area = 0;

        while (!queue.isEmpty()) {
            now = queue.poll();
            area++;
            for (int i = 0; i < 4; i++) {
                nextX = now.x + dx[i];
                nextY = now.y + dy[i];
                if (isValid(nextX, nextY) && map[nextX][nextY]) {
                    map[nextX][nextY] = false;
                    queue.offer(new XY(nextX, nextY));
                }
            }
        }
        areas.add(area);
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                if (temp.charAt(j) == '1')
                    map[i][j] = true;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j])
                    bfs(i, j);
            }
        }

        Collections.sort(areas);
        Iterator<Integer> it = areas.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append('\n');
        }
        System.out.println(areas.size());
        System.out.println(sb);
    }
}

class XY {
    int x, y;

    XY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}