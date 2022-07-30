package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob01948 {
    private static int n, m;
    private static int start, end;

    private static ArrayList<ArrayList<Edge>> graph;
    private static ArrayList<ArrayList<Edge>> invGraph;

    private static int[] indegrees;

    public static void main(String[] args) throws IOException {
        input();

        answerByPhaseSort();
    }

    private static void answerByPhaseSort() {
        int[] maxDistances = new int[n + 1];
        Queue<Edge> queue = new LinkedList<>();
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            for (Edge next : graph.get(now.to)) {
                maxDistances[next.to] = Math.max(maxDistances[next.to], now.distance + next.distance);

                if (--indegrees[next.to] > 0) {
                    continue;
                }
                queue.add(new Edge(next.to, maxDistances[next.to]));
            }
        }

        boolean[] visited = new boolean[n + 1];
        queue.add(new Edge(end, 0));
        int count = 0;
        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            for (Edge edge : invGraph.get(now.to)) {
                if (maxDistances[now.to] != maxDistances[edge.to] + edge.distance) {
                    continue;
                }
                count++;

                if (visited[edge.to]) {
                    continue;
                }
                visited[edge.to] = true;
                queue.add(edge);
            }
        }

        System.out.println(maxDistances[end] + "\n" + count);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = getInitiatedGraph();
        invGraph = getInitiatedGraph();
        indegrees = new int[n + 1];

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Edge(end, distance));
            invGraph.get(end).add(new Edge(start, distance));
            indegrees[end]++;
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    private static ArrayList<ArrayList<Edge>> getInitiatedGraph() {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>(n));
        }

        return graph;
    }

    private static class Edge {
        int to;
        int distance;

        Edge(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }
}