package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class prob118669 {
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static int minIntensity;
    private static int minSummit;

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        initGraph(n, paths);

        HashSet<Integer> summitSet = getSummitSet(summits);
        for (int gate : gates) {
            gate--;
            int[] distance = dijkstra(gate, n, summitSet);

            for (int summit : summits) {
                if (distance[summit] > minIntensity) {
                    continue;
                }
                if (distance[summit] == minIntensity) {
                    minSummit = Math.min(minSummit, summit);
                    continue;
                }
                minIntensity = distance[summit];
                minSummit = summit;
            }
        }
        return new int[] { minSummit + 1, minIntensity };
    }

    private static HashSet<Integer> getSummitSet(int[] summits) {
        HashSet<Integer> summitSet = new HashSet<>();
        for (int i = 0; i < summits.length; i++) {
            summitSet.add(--summits[i]);
        }
        return summitSet;
    }

    private static int[] dijkstra(int start, int n, HashSet<Integer> summitSet) {
        int[] distances = new int[n];

        for (int i = 0; i < n; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0, false));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (distances[now.vertex] < now.cost || minIntensity < now.cost) {
                continue;
            }

            for (Node next : graph.get(now.vertex)) {
                int intensity = Math.max(now.cost, next.cost);
                if (distances[next.vertex] > intensity && !(now.isDone && summitSet.contains(next.vertex))) {
                    distances[next.vertex] = intensity;
                    pq.add(new Node(next.vertex, intensity, summitSet.contains(next.vertex) || now.isDone));
                }
            }
        }
        return distances;
    }

    private static void initGraph(int n, int[][] paths) {
        minIntensity = Integer.MAX_VALUE;
        minSummit = Integer.MAX_VALUE;
        graph.clear();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int n1 = path[0] - 1;
            int n2 = path[1] - 1;
            int cost = path[2];
            graph.get(n1).add(new Node(n2, cost, false));
            graph.get(n2).add(new Node(n1, cost, false));
        }
    }

    private static final class Node implements Comparable<Node> {
        int vertex;
        int cost;
        boolean isDone;

        Node(int vertex, int cost, boolean isDone) {
            this.vertex = vertex;
            this.cost = cost;
            this.isDone = isDone;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost == n.cost ? this.vertex - n.vertex : this.cost - n.cost;
        }

        @Override
        public String toString() {
            return "(" + vertex + "," + cost + ")";
        }
    }

    public static void main(String[] args) {
        int[] n = { 6, 7, 7, 5 };
        int[][][] paths = {
                { { 1, 2, 3 }, { 2, 3, 5 }, { 2, 4, 2 }, { 2, 5, 4 }, { 3, 4, 4 }, { 4, 5, 3 }, { 4, 6, 1 },
                        { 5, 6, 1 } },
                { { 1, 4, 4 }, { 1, 6, 1 }, { 1, 7, 3 }, { 2, 5, 2 }, { 3, 7, 4 }, { 5, 6, 6 } },
                { { 1, 2, 5 }, { 1, 4, 1 }, { 2, 3, 1 }, { 2, 6, 7 }, { 4, 5, 1 }, { 5, 6, 1 }, { 6, 7, 1 } },
                { { 1, 3, 10 }, { 1, 4, 20 }, { 2, 3, 4 }, { 2, 4, 6 }, { 3, 5, 20 }, { 4, 5, 6 } } };
        int[][] gates = { { 1, 3 },
                { 1 },
                { 3, 7 },
                { 1, 2 } };
        int[][] summits = { { 5 },
                { 2, 3, 4 },
                { 1, 5 },
                { 5 } };

        // [5, 3]
        // [3, 4]
        // [5, 1]
        // [5, 6]

        for (int i = 0; i < n.length; i++) {
            int[] ans = solution(n[i], paths[i], gates[i], summits[i]);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
