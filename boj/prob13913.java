package boj;

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class prob13913 {
    static int N, K;
    static final int LOWER_BOUND = 0, UPPER_BOUND = 200000;
    static int[] visited = new int[UPPER_BOUND + 1];

    public static void main(String[] args) {
        input();
        if (N >= K) {
            StringBuilder trace = new StringBuilder();
            trace.append(N - K).append("\n");
            for (int i = N; i >= K; i--) {
                trace.append(i).append(" ");
            }
            System.out.println(trace);
            return;
        }
        int length = bfs();
        System.out.println(length);
        System.out.println(getTrace(length));
    }

    private static String getTrace(int length) {
        int[] trace = new int[length];
        int index = K;
        for (int i = 0; i < trace.length; i++) {
            trace[i] = visited[index];
            index = visited[index];
        }
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < trace.length; i++) {
            t.append(trace[length - 1 - i]).append(" ");
        }
        return t.toString() + K;
    }

    static int bfs() {
        Deque<Trial> queue = new LinkedList<>();
        queue.add(new Trial(N, 0));
        Arrays.fill(visited, -1);
        visited[N] = 0;
        while (!queue.isEmpty()) {
            Trial now = queue.poll();
            int walkLeft = now.x + 1;
            int walkRight = now.x - 1;
            int teleport = now.x * 2;
            if (now.x == K) {
                return now.time;
            }
            if (isValid(teleport) && visited[teleport] < 0) {
                visited[teleport] = now.x;
                queue.add(new Trial(teleport, now.time + 1));
            }
            if (isValid(walkLeft) && visited[walkLeft] < 0) {
                visited[walkLeft] = now.x;
                queue.add(new Trial(walkLeft, now.time + 1));
            }
            if (isValid(walkRight) && visited[walkRight] < 0) {
                visited[walkRight] = now.x;
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