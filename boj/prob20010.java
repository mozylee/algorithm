package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob20010 {
    static int N, K, node;
    static long max;
    static boolean[] visited;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static ArrayList<ArrayList<Edge>> mst = new ArrayList<>();

    public static void main(String[] args) {
        input();
        long ans = prim();
        visited = new boolean[N];
        dfs(0, 0);
        visited = new boolean[N];
        dfs(node, 0);
        System.out.println(ans);
        System.out.println(max);
    }

    static void dfs(int x, long length) {
        if (length > max) {
            max = length;
            node = x;
        }
        visited[x] = true;
        for (Edge next : mst.get(x)) {
            if (!visited[next.end]) {
                dfs(next.end, length + next.distance);
            }
        }
    }

    static long prim() {
        long mstDistance = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        visited = new boolean[N];
        pq.add(new Edge(-1, 0, 0));
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (visited[now.end]) {
                continue;
            }
            visited[now.end] = true;
            if (now.distance > 0) {
                mst.get(now.start).add(new Edge(now, false));
                mst.get(now.end).add(new Edge(now, true));
            }
            mstDistance += now.distance;
            for (Edge next : graph.get(now.end)) {
                if (!visited[next.end]) {
                    pq.add(next);
                }
            }
        }
        return mstDistance;
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<Edge>());
                mst.add(new ArrayList<Edge>());
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int distance = Integer.parseInt(st.nextToken());
                graph.get(start).add(new Edge(start, end, distance));
                graph.get(end).add(new Edge(end, start, distance));
            }
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }

    static class Edge implements Comparable<Edge> {
        int start, end, distance;

        Edge(int s, int e, int d) {
            start = s;
            end = e;
            distance = d;
        }

        Edge(Edge e, boolean isReversed) {
            if (isReversed) {
                this.start = e.end;
                this.end = e.start;
            } else {
                this.start = e.start;
                this.end = e.end;
            }
            this.distance = e.distance;
        }

        @Override
        public int compareTo(Edge e) {
            return this.distance - e.distance;
        }
    }
}
