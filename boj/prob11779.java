package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class prob11779 {
    static int N, s, e;
    static int[] distances, routes;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) {
        dijkstra(s, getMap());

        System.out.println("DISTANCES");
        for (int i = 0; i < N; i++) {
            System.out.print(distances[i] + " ");
        }
        System.out.println("\nROUTES");
        for (int i = 0; i < N; i++) {
            System.out.print(routes[i] + " ");
        }
        System.out.println();
        StringBuilder sb = new StringBuilder();
        sb.append(distances[e]).append('\n');
        Stack<Integer> trace = new Stack<>();
        int temp = e;
        while (temp != -1) {
            trace.push(temp + 1);
            temp = routes[temp];
            if (temp == s) {
                trace.push(temp + 1);
            }
        }
        sb.append(trace.size()).append('\n');
        while (!trace.isEmpty()) {
            sb.append(trace.pop()).append(' ');
        }
        System.out.println(sb);
    }

    public static int[] dijkstra(int start, int[][] map) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        routes = new int[N];
        Arrays.fill(routes, -1);
        distances = new int[N];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (now.weight > distances[now.end])
                continue;
            for (Edge next : graph.get(now.end)) {
                int nextWeight = next.weight + now.weight;
                if (nextWeight < distances[next.end]) {
                    distances[next.end] = nextWeight;
                    routes[next.end] = now.end;
                    pq.add(new Edge(next.end, nextWeight));
                }
            }
        }
        return distances;
    }

    public static int[][] getMap() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
                Arrays.fill(map[i], Integer.MAX_VALUE);
                map[i][i] = 0;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                int weight = Integer.parseInt(st.nextToken());
                map[start][end] = weight;
                graph.get(start).add(new Edge(end, weight));
            }
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()) - 1;
            e = Integer.parseInt(st.nextToken()) - 1;
            return map;
        } catch (Exception e) {
            return new int[][] {};
        }
    }

    static class Edge implements Comparable<Edge> {
        int end, weight;

        Edge(int e, int w) {
            end = e;
            weight = w;
        }

        @Override
        public int compareTo(Edge e) {
            if (this.weight == e.weight)
                return this.end - e.end;
            return this.weight - e.weight;
        }
    }
}
