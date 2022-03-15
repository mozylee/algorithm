package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob01368 {
    private static int N;

    private static ArrayList<Vertex> waters = new ArrayList<>();
    private static HashMap<Integer, ArrayList<Vertex>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(prim());
    }

    private static long prim() {
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        long totalCost = 0;

        for (Vertex water : waters) {
            pq.add(water);
        }

        while (!pq.isEmpty()) {
            Vertex now = pq.poll();

            if (visited[now.v]) {
                continue;
            }
            visited[now.v] = true;
            totalCost += now.cost;

            for (Vertex next : graph.get(now.v)) {
                if (visited[next.v]) {
                    continue;
                }
                pq.add(next);
            }
        }
        return totalCost;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            waters.add(new Vertex(i, Integer.parseInt(br.readLine())));
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            graph.put(i, new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    st.nextToken();
                    continue;
                }
                graph.get(i).add(new Vertex(j, Integer.parseInt(st.nextToken())));
            }
        }
    }

    private static final class Vertex implements Comparable<Vertex> {
        int v;
        int cost;

        Vertex(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex v) {
            return this.cost - v.cost;
        }
    }
}
