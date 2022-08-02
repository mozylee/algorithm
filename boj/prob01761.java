package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob01761 {
    private static int N;
    private static int HEIGHT;

    private static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    private static Queue<String> queries = new LinkedList<>();

    private static int[][] parents;
    private static int[] distances;
    private static int[] depth;

    public static void main(String[] args) throws IOException {
        input();

        dfs(1, 0, 0, 0);
        initParents();

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (!queries.isEmpty()) {
            st = new StringTokenizer(queries.poll());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getDistance(a, b)).append("\n");
        }

        System.out.print(sb);
    }

    private static int getDistance(int a, int b) {
        return distances[a] + distances[b] - 2 * distances[getLCA(a, b)];
    }

    private static void dfs(int now, int level, int length, int parent) {
        depth[now] = level;

        for (Edge next : graph.get(now)) {
            if (next.node == parent) {
                continue;
            }
            parents[next.node][0] = now;
            distances[next.node] = length + next.distance;
            dfs(next.node, level + 1, length + next.distance, now);
        }
    }

    private static void initParents() {
        for (int i = 1; i < HEIGHT; i++) {
            for (int j = 1; j <= N; j++) {
                parents[j][i] = parents[parents[j][i - 1]][i - 1];
            }
        }
    }

    private static int getLCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = b;
            b = a;
            a = temp;
        }

        for (int i = HEIGHT - 1; i >= 0; i--) {
            if ((int) Math.pow(2, i) > depth[a] - depth[b]) {
                continue;
            }

            a = parents[a][i];
        }

        if (a == b) {
            return a;
        }

        for (int i = HEIGHT - 1; i >= 0; i--) {
            if (parents[a][i] != parents[b][i]) {
                a = parents[a][i];
                b = parents[b][i];
            }
        }

        return parents[a][0];
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        HEIGHT = log2(N) + 1;
        depth = new int[N + 1];
        parents = new int[N + 1][HEIGHT];
        distances = new int[N + 1];

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, distance));
            graph.get(b).add(new Edge(a, distance));
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            queries.add(br.readLine());
        }
    }

    private static int log2(int n) {
        return (int) Math.ceil(Math.log(n) / Math.log(2));
    }

    private static class Edge {
        int node;
        int distance;

        Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
