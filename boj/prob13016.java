package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class prob13016 {
    static int N, max, node;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[][] lengthes;

    public static void main(String[] args) {
        input();
        lengthes = new int[2][N];
        visited = new boolean[N];
        dfs(0, 0, 0);
        int start = node;
        visited = new boolean[N];
        dfs(start, 0, 0);
        int end = node;
        visited = new boolean[N];
        dfs(end, 0, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(Math.max(lengthes[0][i], lengthes[1][i])).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int x, int length, int parent) {
        if (length > max) {
            max = length;
            node = x;
        }
        visited[x] = true;
        lengthes[parent][x] = length;
        for (Edge next : graph.get(x)) {
            if (!visited[next.vertex]) {
                dfs(next.vertex, length + next.distance, parent);
            }
        }
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                int length = Integer.parseInt(st.nextToken());
                graph.get(from).add(new Edge(to, length));
                graph.get(to).add(new Edge(from, length));
            }
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }

    static class Edge {
        int vertex, distance;

        Edge(int v, int d) {
            vertex = v;
            distance = d;
        }
    }
}
