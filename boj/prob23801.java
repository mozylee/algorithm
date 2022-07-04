package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob23801 {
    private static int N;
    private static HashMap<Integer, ArrayList<Node>> graph = new HashMap<>();

    private static int x, z;
    private static ArrayList<Integer> middleNodes = new ArrayList<>();

    private static final long MAX_DISTANCE = 300_000L * 1_000_000L * 100L + 1;

    public static void main(String[] args) throws IOException {
        input();

        long[] distancesX = dijkstra(x);
        long[] distancesZ = dijkstra(z);

        long min = MAX_DISTANCE;
        for (int p : middleNodes) {
            if (distancesX[p] == MAX_DISTANCE || distancesZ[p] == MAX_DISTANCE) {
                continue;
            }
            min = Math.min(min, distancesX[p] + distancesZ[p]);
        }
        System.out.println(min < MAX_DISTANCE ? min : -1);
    }

    private static long[] dijkstra(int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, 0));

        long[] distances = new long[N + 1];
        Arrays.fill(distances, MAX_DISTANCE);
        distances[x] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.distance > distances[now.vertex]) {
                continue;
            }

            for (Node next : graph.get(now.vertex)) {
                if (now.distance + next.distance >= distances[next.vertex]) {
                    continue;
                }

                distances[next.vertex] = now.distance + next.distance;

                pq.add(new Node(next.vertex, distances[next.vertex]));
            }
        }
        return distances;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());

        int P = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < P; i++) {
            middleNodes.add(Integer.parseInt(st.nextToken()));
        }
    }

    private static final class Node implements Comparable<Node> {
        int vertex;
        long distance;

        public Node(int n, long distance) {
            this.vertex = n;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node n) {
            return Long.compare(this.distance, n.distance);
        }
    }
}
