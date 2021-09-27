package boj;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class prob13549 {
    static int N, K;
    static final int LOWER_BOUND = 0, UPPER_BOUND = 200000;

    public static void main(String[] args) {
        input();
        System.out.println(bfs());
    }

    static int bfs() {
        Deque<Trial> queue = new LinkedList<>();
        boolean[] visited = new boolean[UPPER_BOUND + 1];
        queue.add(new Trial(N, 0));
        visited[N] = true;
        while (!queue.isEmpty()) {
            Trial now = queue.poll();
            int walkLeft = now.x + 1;
            int walkRight = now.x - 1;
            int teleport = now.x * 2;
            if (now.x == K || teleport == K) {
                return now.time;
            }
            if (walkLeft == K || walkRight == K) {
                return now.time + 1;
            }
            if (isValid(teleport) && !visited[teleport]) {
                visited[teleport] = true;
                queue.addFirst(new Trial(teleport, now.time));
            }
            if (isValid(walkLeft) && !visited[walkLeft]) {
                visited[walkLeft] = true;
                queue.add(new Trial(walkLeft, now.time + 1));
            }
            if (isValid(walkRight) && !visited[walkRight]) {
                visited[walkRight] = true;
                queue.add(new Trial(walkRight, now.time + 1));
            }
        }
        return -1;
    }

    static boolean isValid(int x) {
        return x >= LOWER_BOUND && x <= UPPER_BOUND;
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
        } catch (Exception e) {
            System.out.println("ERROR!!!");
        }
    }

    static class Trial {
        int x, time;

        Trial(int x, int t) {
            this.x = x;
            time = t;
        }
    }
}