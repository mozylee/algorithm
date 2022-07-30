package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob11437 {
    private static int N;

    private static int HEIGHT;

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static Queue<String> queries = new LinkedList<>();

    private static int[][] parents;
    private static int[] depth;

    public static void main(String[] args) throws IOException {
        input();

        dfs(1, 0, 0);
        initParents();

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (!queries.isEmpty()) {
            st = new StringTokenizer(queries.poll());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getLCA(a, b)).append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int now, int level, int parent) {
        depth[now] = level;

        for (int next : graph.get(now)) {
            if (next == parent) {
                continue;
            }
            parents[next][0] = now;
            dfs(next, level + 1, now);
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

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            queries.add(br.readLine());
        }
    }

    private static int log2(int n) {
        return (int) Math.ceil(Math.log(n) / Math.log(2));
    }
}
