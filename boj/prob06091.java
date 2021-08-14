package boj;

import java.io.*;
import java.util.*;

public class prob06091 {
    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[][] floydMap;

    public static void main(String[] args) {
        input();
        PriorityQueue<Path> pq = new PriorityQueue<>();
        boolean[] linked = new boolean[N];
        int start = 0;
        linked[start] = true;
        for (int count = 0; count < N - 1; count++) {
            for (int end = 0; end < N; end++) {
                if (!linked[end]) {
                    pq.add(new Path(start, end, floydMap[start][end]));
                }
            }
            Path path = pq.poll();
            while (linked[path.end]) {
                path = pq.poll();
            }
            linked[path.end] = true;
            graph.get(path.start).add(path.end);
            graph.get(path.end).add(path.start);
            start = path.end;
        }
        output(graph);
    }

    static void output(ArrayList<ArrayList<Integer>> graph) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> vertex = graph.get(i);
            sb.append(vertex.size()).append(" ");
            Collections.sort(vertex);
            for (Integer adjacent : vertex) {
                sb.append(adjacent + 1).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            floydMap = new int[N][N];
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                floydMap[i][i] = Integer.MAX_VALUE;
                for (int j = i + 1; j < N; j++) {
                    floydMap[i][j] = floydMap[j][i] = Integer.parseInt(st.nextToken());
                }
                graph.add(new ArrayList<>());
            }
            floydMap[N - 1][N - 1] = Integer.MAX_VALUE;
            graph.add(new ArrayList<>());
        } catch (Exception e) {
        }
    }

    static class Path implements Comparable<Path> {
        int start, end, distance;

        Path(int s, int e, int d) {
            start = s;
            end = e;
            distance = d;
        }

        @Override
        public int compareTo(Path e) {
            return this.distance - e.distance;
        }
    }
}
