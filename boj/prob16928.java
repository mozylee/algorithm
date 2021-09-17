package boj;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob16928 {
    static int N, M;
    static HashMap<Integer, Integer> connected = new HashMap<>();

    public static void main(String[] args) {
        input();
        System.out.println(bfs());
    }

    static int bfs() {
        int[] visited = new int[101];
        Arrays.fill(visited, Integer.MAX_VALUE);
        Queue<Trial> queue = new LinkedList<>();
        queue.add(new Trial(1, 0));
        while (!queue.isEmpty()) {
            Trial now = queue.poll();
            int nextCount = now.count + 1;
            for (int i = 1; i <= 6; i++) {
                int next = now.value + i;
                if (connected.containsKey(next)) {
                    next = connected.get(next);
                }
                if (visited[next] <= nextCount) {
                    continue;
                }
                if (next == 100) {
                    return nextCount;
                }
                visited[next] = nextCount;
                queue.add(new Trial(next, nextCount));
            }
        }
        return -1;
    }

    static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N + M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                connected.put(start, end);
            }
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }

    static class Trial {
        int value, count;

        Trial(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
