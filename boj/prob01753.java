package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob01753 {
    private static int V, E, start;
    private static HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
    private static int[] distances;
    private static final String INF = "INF";

    public static void main(String[] args) throws IOException {
        input();
        dijkstra();
        StringBuilder sb = new StringBuilder();
        for (int i : distances) {
            sb.append(i < Integer.MAX_VALUE ? i : INF).append("\n");
        }
        System.out.println(sb);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distances[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (distances[now.v] < now.w) {
                continue;
            }
            for (Map.Entry<Integer, Integer> next : graph.get(now.v).entrySet()) {
                int weight = now.w + next.getValue();
                if (weight < distances[next.getKey()]) {
                    distances[next.getKey()] = weight;
                    pq.add(new Node(next.getKey(), weight));
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine()) - 1;
        distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        for (int i = 0; i < V; i++) {
            graph.put(i, new HashMap<>());
        }
        int u, v, w;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken()) - 1;
            v = Integer.parseInt(st.nextToken()) - 1;
            w = Integer.parseInt(st.nextToken());
            if (!graph.get(u).containsKey(v)) {
                graph.get(u).put(v, w);
            }
            graph.get(u).put(v, Math.min(graph.get(u).get(v), w));
        }
    }

    static class Node implements Comparable<Node> {
        int v, w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node n) {
            return this.w - n.w;
        }
    }
}
