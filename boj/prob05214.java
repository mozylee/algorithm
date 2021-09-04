package boj;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class prob05214 {
    static int N, L, start, end;
    static ArrayList<HashSet<Integer>> lines = new ArrayList<>();
    static ArrayList<HashSet<Integer>> stations = new ArrayList<>();

    public static void main(String[] args) {
        input();
        if (start == end) {
            System.out.println(1);
            System.exit(0);
        }
        int distance = bfs();
        System.out.println(distance == -1 ? -1 : distance + 1);
    }

    static int bfs() {
        Queue<Count> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        boolean[] visitedLine = new boolean[L];
        visited[start] = true;
        queue.add(new Count(start, 0));
        while (!queue.isEmpty()) {
            Count now = queue.poll();
            for (int nextLine : stations.get(now.station)) {
                if (visitedLine[nextLine])
                    continue;
                visitedLine[nextLine] = true;
                for (int nextStation : lines.get(nextLine)) {
                    if (nextStation == end) {
                        return now.count + 1;
                    }
                    if (visited[nextStation])
                        continue;
                    visited[nextStation] = true;
                    queue.add(new Count(nextStation, now.count + 1));
                }
            }
        }
        return -1;
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            for (int i = 0; i <= N; i++) {
                stations.add(new HashSet<>());
            }
            for (int i = 0; i < L; i++) {
                st = new StringTokenizer(br.readLine());
                lines.add(new HashSet<>());
                for (int j = 0; j < k; j++) {
                    int station = Integer.parseInt(st.nextToken());
                    lines.get(i).add(station);
                    stations.get(station).add(i);
                }
            }
            start = 1;
            end = N;
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }

    static class Count {
        int station, count;

        Count(int s, int c) {
            station = s;
            count = c;
        }
    }
}