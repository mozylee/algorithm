package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob01865 {
    private static int N, M, W;

    private static Edge[] adj;

    private static int[] distances;
    private static final int INF = 10_000_000;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            input();
            sb.append(bellmanford() ? "YES" : "NO").append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    private static boolean bellmanford() {
        Arrays.fill(distances, INF);
        distances[1] = 0;

        for (int i = 1; i < N; i++) {
            for (Edge e : adj) {
                if (distances[e.start] + e.distance < distances[e.end]) {
                    distances[e.end] = distances[e.start] + e.distance;
                }
            }
        }

        for (Edge e : adj) {
            if (distances[e.start] + e.distance < distances[e.end]) {
                return true;
            }
        }
        return false;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        distances = new int[N + 1];
        adj = new Edge[2 * M + W];
        int index = 0;

        int S, E, T;
        for (int i = 0; i < M + W; i++) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            adj[index++] = new Edge(S, E, T * (i < M ? 1 : -1));
            if (i < M) {
                adj[index++] = new Edge(E, S, T);
            }
        }
    }

    private static class Edge {
        int start, end, distance;

        Edge(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
}
