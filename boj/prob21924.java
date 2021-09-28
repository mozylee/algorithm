package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob21924 {
    private static int N;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        int M = Integer.valueOf(st.nextToken());
        long sum = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            int d = Integer.valueOf(st.nextToken());
            graph.get(s).add(new Node(e, d));
            graph.get(e).add(new Node(s, d));
            sum += d;
        }
        long mst = prim();
        System.out.println(mst >= 0 ? sum - mst : -1);
    }

    private static long prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        boolean[] visited = new boolean[N + 1];
        long mst = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.location])
                continue;
            visited[now.location] = true;
            mst += now.distance;
            for (Node next : graph.get(now.location)) {
                pq.add(next);
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i])
                return -1;
        }
        return mst;
    }

    static class Node implements Comparable<Node> {
        int location, distance;

        Node(int location, int distance) {
            this.location = location;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.distance, n.distance);
        }
    }
}
