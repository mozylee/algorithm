package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob14284 {
    private static int N;
    private static int s, t;
    private static HashMap<Integer, ArrayList<Node>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));

        int[] distances = new int[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.distance > distances[now.vertex]) {
                continue;
            }

            for (Node next : graph.get(now.vertex)) {
                if (now.distance + next.distance >= distances[next.vertex]) {
                    continue;
                }

                distances[next.vertex] = now.distance + next.distance;

                pq.add(new Node(next.vertex, distances[next.vertex]));
            }
        }
        return distances[t];
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
    }

    private static final class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int n, int cost) {
            this.vertex = n;
            this.distance = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.distance - n.distance;
        }
    }
}
