package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob02887 {
    static int N;
    static ArrayList<Planet> planets = new ArrayList<>();
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) {
        input();
        makeGraph();
        System.out.println(prim());
    }

    static void makeGraph() {
        Collections.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet p1, Planet p2) {
                return p1.x - p2.x;
            }
        });
        makeEdges();

        Collections.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet p1, Planet p2) {
                return p1.y - p2.y;
            }
        });
        makeEdges();

        Collections.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet p1, Planet p2) {
                return p1.z - p2.z;
            }
        });
        makeEdges();
    }

    static void makeEdges() {
        for (int i = 0; i < N - 1; i++) {
            Planet p1 = planets.get(i);
            Planet p2 = planets.get(i + 1);
            int distance = getDistance(p1, p2);
            graph.get(p1.name).add(new Edge(p2.name, distance));
            graph.get(p2.name).add(new Edge(p1.name, distance));
        }
    }

    static int getDistance(Planet p1, Planet p2) {
        int min = Math.min(Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y));
        return Math.min(min, Math.abs(p1.z - p2.z));
    }

    static int prim() {
        int mst = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] connected = new boolean[N];
        pq.add(new Edge(0, 0));
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (connected[now.vertex])
                continue;
            connected[now.vertex] = true;
            mst += now.distance;
            for (Edge next : graph.get(now.vertex)) {
                pq.add(new Edge(next));
            }
        }
        return mst;
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int[] coords = new int[3];
                for (int j = 0; j < 3; j++) {
                    coords[j] = Integer.parseInt(st.nextToken());
                }
                planets.add(new Planet(i, coords[0], coords[1], coords[2]));
                graph.add(new ArrayList<>());
            }
        } catch (Exception e) {
            System.out.println("ERROR!!!!");
        }
    }

    static class Edge implements Comparable<Edge> {
        int vertex, distance;

        Edge(int next, int distance) {
            this.vertex = next;
            this.distance = distance;
        }

        Edge(Edge e) {
            this(e.vertex, e.distance);
        }

        @Override
        public int compareTo(Edge e) {
            return this.distance - e.distance;
        }
    }

    static class Planet {
        int name, x, y, z;

        Planet(int name, int x, int y, int z) {
            this.name = name;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
