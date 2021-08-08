package boj;

import java.io.*;
import java.util.*;

public class prob14950 {
    static int N, t, ans;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) {
        input();
        ans += t * (N - 2) * (N - 1) / 2;
        ans += prim(0);
        System.out.println(ans);
    }

    public static int prim(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        pq.add(new Edge(start, 0));
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (visited[now.v])
                continue;
            visited[now.v] = true;
            sum += now.w;
            for (Edge next : graph.get(now.v))
                if (!visited[next.v])
                    pq.add(new Edge(next));
        }
        return sum;
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++)
                graph.add(new ArrayList<>());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()) - 1;
                int e = Integer.parseInt(st.nextToken()) - 1;
                int w = Integer.parseInt(st.nextToken());
                graph.get(s).add(new Edge(e, w));
                graph.get(e).add(new Edge(s, w));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    static class Edge implements Comparable<Edge> {
        int v, w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        Edge(Edge e) {
            this(e.v, e.w);
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.w, e.w);
        }
    }
}
