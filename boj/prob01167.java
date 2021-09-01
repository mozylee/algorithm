package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class prob01167 {
    static int V, node, max;
    static boolean[] visited;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) {
        input();
        visited = new boolean[V];
        dfs(0, 0);
        visited = new boolean[V];
        dfs(node, 0);
        System.out.println(max);
    }

    static void dfs(int x, int length) {
        if (length > max) {
            max = length;
            node = x;
        }
        visited[x] = true;
        for (Edge next : graph.get(x)) {
            if (!visited[next.vertex]) {
                dfs(next.vertex, length + next.distance);
            }
        }
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            V = Integer.parseInt(br.readLine());
            for (int i = 0; i < V; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < V; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                while (true) {
                    int next = Integer.parseInt(st.nextToken());
                    if (next == -1)
                        break;
                    int distance = Integer.parseInt(st.nextToken());
                    graph.get(start - 1).add(new Edge(next - 1, distance));
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }

    static class Edge implements Comparable<Edge> {
        int vertex, distance;

        Edge(int v, int d) {
            vertex = v;
            distance = d;
        }

        @Override
        public int compareTo(Edge e) {
            return this.distance - e.distance;
        }

        @Override
        public String toString() {
            return "(" + vertex + "," + distance + ")";
        }
    }
}
