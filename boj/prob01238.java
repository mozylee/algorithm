package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob01238 {
    static int N, X;
    static ArrayList<Edge>[] graph;

    public static void main(String[] args) {
        int[][] map = getMap();
        int[][] totalDistances = new int[N][];
        for (int i = 0; i < N; i++)
            totalDistances[i] = dijkstra(i, map);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++)
            max = Math.max(max, totalDistances[X][i] + totalDistances[i][X]);
        System.out.println(max);
    }

    public static int[] dijkstra(int start, int[][] map) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] distances = new int[N];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (now.weight > distances[now.end])
                continue;
            for (Edge next : graph[now.end]) {
                int nextWeight = next.weight + now.weight;
                if (nextWeight < distances[next.end]) {
                    distances[next.end] = nextWeight;
                    pq.add(new Edge(next.end, nextWeight));
                }
            }
        }
        return distances;
    }

    public static int[][] getMap() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken()) - 1;
            int[][] map = new int[N][N];
            // Type 에러가 떠서 일단 주석처리
            // graph = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
                Arrays.fill(map[i], Integer.MAX_VALUE);
                map[i][i] = 0;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                int weight = Integer.parseInt(st.nextToken());
                map[start][end] = weight;
                graph[start].add(new Edge(end, weight));
            }
            return map;
        } catch (Exception e) {
            return new int[][] {};
        }
    }

    static class Edge implements Comparable<Edge> {
        int end, weight;

        Edge(int e, int w) {
            end = e;
            weight = w;
        }

        @Override
        public int compareTo(Edge e) {
            if (this.weight == e.weight)
                return this.end - e.end;
            return this.weight - e.weight;
        }
    }

    static void print(int[][] arr) {
        for (int[] is : arr) {
            for (int n : is) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
