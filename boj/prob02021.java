package boj;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class prob02021 {
    static int N, L, start, end;
    static ArrayList<HashSet<Integer>> lines = new ArrayList<>();
    static ArrayList<HashSet<Integer>> stations = new ArrayList<>();

    public static void main(String[] args) {
        input();
        if (start == end) {
            System.out.println(0);
            System.exit(0);
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Count> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        boolean[] visitedLine = new boolean[L];
        for (int line : stations.get(start)) {
            queue.add(new Count(line, 0));
            visitedLine[line] = true;
        }
        visited[start] = true;
        while (!queue.isEmpty()) {
            Count now = queue.poll();
            for (int nextStation : lines.get(now.line)) {
                if (nextStation == end) {
                    return now.count;
                }
                if (!visited[nextStation]) {
                    visited[nextStation] = true;
                    for (int nextLine : stations.get(nextStation)) {
                        if (!visitedLine[nextLine]) {
                            visitedLine[nextLine] = true;
                            queue.add(new Count(nextLine, now.count + 1));
                        }
                    }
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
            L = Integer.parseInt(st.nextToken());
            for (int i = 0; i <= N; i++) {
                stations.add(new HashSet<>());
            }
            for (int i = 0; i < L; i++) {
                st = new StringTokenizer(br.readLine());
                lines.add(new HashSet<>());
                while (true) {
                    int station = Integer.parseInt(st.nextToken());
                    if (station < 0) {
                        break;
                    }
                    lines.get(i).add(station);
                    stations.get(station).add(i);
                }
            }
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }

    static class Count {
        int line, count;

        Count(int s, int c) {
            line = s;
            count = c;
        }
    }
}