package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob09370 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int n, m, t, s, g, h;
    private static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    private static ArrayList<Integer> candidates = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            input();
            int[] distanceS = dijkstra(s);
            int next = distanceS[g] < distanceS[h] ? h : g;
            int[] distanceNext = dijkstra(next);
            candidates.sort(null);

            for (int candidate : candidates) {
                if (distanceS[candidate] != distanceS[next] + distanceNext[candidate]) {
                    continue;
                }
                sb.append(candidate).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int[] dijkstra(int start) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        distances[start] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            visited[current.vertex] = true;

            for (Edge next : graph.get(current.vertex)) {
                if (visited[next.vertex] || distances[current.vertex] + next.distance >= distances[next.vertex]) {
                    continue;
                }
                distances[next.vertex] = distances[current.vertex] + next.distance;
                pq.add(new Edge(next.vertex, distances[next.vertex]));
            }
        }

        return distances;
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        graph.clear();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int a, b, d;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, d));
            graph.get(b).add(new Edge(a, d));
        }

        candidates.clear();
        for (int i = 0; i < t; i++) {
            candidates.add(Integer.parseInt(br.readLine()));
        }
    }

    static class Edge implements Comparable<Edge> {
        int vertex, distance;

        Edge(int next, int distance) {
            this.vertex = next;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge e) {
            return this.distance - e.distance;
        }
    }
}
