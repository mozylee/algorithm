package boj;

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class prob12851 {
    static int N, K;
    static int min = Integer.MAX_VALUE, count;
    static final int LOWER_BOUND = 0, UPPER_BOUND = 200000;

    public static void main(String[] args) {
        input();
        bfs();
        System.out.println(min);
        System.out.println(count);
    }

    static void bfs() {
        Deque<Integer> queue = new LinkedList<>();
        int[] visited = new int[UPPER_BOUND + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        queue.add(N);
        visited[N] = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            int walkLeft = now + 1;
            int walkRight = now - 1;
            int teleport = now * 2;
            if (now == K) {
                if (visited[now] < min) {
                    min = visited[now];
                    count = 0;
                }
                count++;
                continue;
            }
            if (isValid(teleport) && visited[teleport] >= visited[now] + 1) {
                visited[teleport] = visited[now] + 1;
                queue.addFirst(teleport);
            }
            if (isValid(walkLeft) && visited[walkLeft] >= visited[now] + 1) {
                visited[walkLeft] = visited[now] + 1;
                queue.add(walkLeft);
            }
            if (isValid(walkRight) && visited[walkRight] >= visited[now] + 1) {
                visited[walkRight] = visited[now] + 1;
                queue.add(walkRight);
            }
        }
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
