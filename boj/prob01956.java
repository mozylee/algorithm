package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob01956 {
    private static int V, E;
    private static final int INF = 10_000_000;

    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        input();
        floydWarshall();

        int min = INF;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                min = Math.min(min, graph[i][j] + graph[j][i]);
            }
        }
        System.out.println(min < INF ? min : -1);
    }

    private static void floydWarshall() {
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                if (k == i)
                    continue;
                for (int j = 0; j < V; j++) {
                    if (i == j || k == j)
                        continue;
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new int[V][V];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            graph[s][e] = d;
        }
    }
}
