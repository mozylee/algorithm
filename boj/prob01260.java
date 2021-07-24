package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class prob01260 {
    static boolean[][] graph;
    static boolean[] visited;
    static int n, start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int v = Integer.valueOf(st.nextToken()) - 1;
        graph = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.valueOf(st.nextToken());
            end = Integer.valueOf(st.nextToken());
            addEdge(start - 1, end - 1);
        }
        initVisited();
        dfs(v);
        System.out.println();
        initVisited();
        bfs(v);
    }

    static void addEdge(int start, int end) {
        graph[start][end] = true;
        graph[end][start] = true;
    }

    static void initVisited() {
        visited = new boolean[n];
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + 1 + " ");
            for (int i = 0; i < n; i++)
                if (graph[now][i] && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
        }
    }

    static void dfs(int now) {
        if (visited[now])
            return;
        visited[now] = true;
        System.out.print(now + 1 + " ");
        for (int i = 0; i < n; i++)
            if (graph[now][i] && !visited[i]) {
                dfs(i);
            }
    }
}