package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob14630 {
    private static int N;
    private static int from, to;

    private static List<Part> parts;

    public static void main(String[] args) throws IOException {
        input();

        int[][] graph = initGraph();

        System.out.println(dijkstra(from, to, graph));
    }

    private static int dijkstra(int f, int t, int[][] graph) {
        int[] distances = new int[N];
        Arrays.fill(distances, 100_000_000);
        distances[f] = 0;
        PriorityQueue<Trial> pq = new PriorityQueue<>();
        pq.add(new Trial(f, 0));

        while (!pq.isEmpty()) {
            Trial now = pq.poll();

            for (int i = 0; i < N; i++) {
                if (i == now.x) {
                    continue;
                }

                int distance = graph[now.x][i] + now.distance;
                if (distance >= distances[i]) {
                    continue;
                }
                distances[i] = distance;
                pq.add(new Trial(i, distance));
            }
        }

        return distances[t];
    }

    private static int[][] initGraph() {
        int[][] graph = new int[N][N];
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int distance = parts.get(i).getDistance(parts.get(j));

                graph[i][j] = distance;
                graph[j][i] = distance;
            }
        }
        return graph;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        parts = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            parts.add(new Part(br.readLine()));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken()) - 1;
        to = Integer.parseInt(st.nextToken()) - 1;
    }

    private static class Part {
        int[] parts;

        Part(String s) {
            parts = new int[s.length()];
            for (int i = 0; i < parts.length; i++) {
                parts[i] = s.charAt(i) - '0';
            }
        }

        int getDistance(Part p) {
            int distance = 0;

            for (int i = 0; i < parts.length; i++) {
                int gap = Math.abs(p.parts[i] - parts[i]);
                distance += gap * gap;
            }

            return distance;
        }
    }

    private static class Trial implements Comparable<Trial> {
        int x;
        int distance;

        Trial(int x, int distance) {
            this.x = x;
            this.distance = distance;
        }

        @Override
        public int compareTo(Trial t) {
            return Integer.compare(this.distance, t.distance);
        }
    }
}
