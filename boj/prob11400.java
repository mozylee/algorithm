package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class prob11400 {
    private static int V, E;
    private static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static ArrayList<Bridge> articulationBridges = new ArrayList<>();
    private static int[] levels;
    private static int level;

    public static void main(String[] args) throws IOException {
        input();
        levels = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            if (levels[i] > 0) {
                continue;
            }
            dfs(i, 0);
        }

        StringBuilder sb = new StringBuilder();
        articulationBridges.sort(null);
        sb.append(articulationBridges.size()).append("\n");
        for (Bridge aB : articulationBridges) {
            sb.append(aB).append("\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int now, int parent) {
        levels[now] = ++level;
        int ret = levels[now];
        for (int next : graph.get(now)) {
            if (next == parent) {
                continue;
            }
            if (levels[next] > 0) {
                ret = Math.min(ret, levels[next]);
                continue;
            }
            int row = dfs(next, now);
            ret = Math.min(ret, row);
            if (levels[now] < row) {
                articulationBridges.add(new Bridge(Math.min(now, next), Math.max(now, next)));
            }
        }
        return ret;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= V; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start == end) {
                continue;
            }
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
    }

    static class Bridge implements Comparable<Bridge> {
        int start, end;

        Bridge(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Bridge b) {
            return this.start != b.start ? this.start - b.start : this.end - b.end;
        }

        @Override
        public String toString() {
            return start + " " + end;
        }
    }
}