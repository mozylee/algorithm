package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob11657 {
    private static int N, M;
    private static Edge[] edges;

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();

        long[] distances = new long[N];
        Arrays.fill(distances, INF);
        distances[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (distances[edges[j].start] == INF
                        || distances[edges[j].end] < distances[edges[j].start] + edges[j].distance) {
                    continue;
                }
                distances[edges[j].end] = distances[edges[j].start] + edges[j].distance;
            }
        }

        for (int i = 0; i < M; i++) {
            if (distances[edges[i].start] == INF) {
                continue;
            }
            if (distances[edges[i].end] > distances[edges[i].start] + edges[i].distance) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            sb.append(distances[i] < INF ? distances[i] : -1).append("\n");
        }
        System.out.print(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int distance = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, distance);
        }
    }

    private static final class Edge {
        int start, end, distance;

        Edge(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
}
