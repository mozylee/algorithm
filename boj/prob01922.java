package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob01922 {
    private static HashMap<Integer, ArrayList<Node>> graph;
    private static int N;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(prim());
    }

    private static int prim() {
        boolean[] visited = new boolean[N + 1];
        int mst = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.location]) {
                continue;
            }
            visited[now.location] = true;
            mst += now.distance;
            graph.get(now.location).forEach(next -> {
                if (!visited[next.location])
                    pq.add(next);
            });
        }
        return mst;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        initGraph();
        int M = Integer.valueOf(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            if (start == end)
                continue;
            int distance = Integer.valueOf(st.nextToken());
            graph.get(start).add(new Node(end, distance));
            graph.get(end).add(new Node(start, distance));
        }
    }

    private static void initGraph() {
        graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }
    }

    static class Node implements Comparable<Node> {
        int location, distance;

        Node(int location, int distance) {
            this.location = location;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node n) {
            return this.distance - n.distance;
        }
    }
}
