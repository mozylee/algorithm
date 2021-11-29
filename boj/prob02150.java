package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class prob02150 {
    private static int N, K;
    private static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static HashMap<Integer, ArrayList<Integer>> graphInv = new HashMap<>();
    private static Stack<Integer> stack = new Stack<>();
    private static ArrayList<Integer> scc = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(i, visited);
        }
        Arrays.fill(visited, false);
        ArrayList<SCC> sccs = new ArrayList<>();
        while (!stack.isEmpty()) {
            int now = stack.pop();
            if (visited[now]) {
                continue;
            }
            visited[now] = true;
            dfsInv(now, visited);
            sccs.add(new SCC(scc));
            scc.clear();
        }

        StringBuilder sb = new StringBuilder();
        sccs.sort(null);
        for (SCC scc : sccs) {
            sb.append(scc).append(-1).append("\n");
        }
        System.out.println(sccs.size());
        System.out.println(sb);
    }

    private static void dfs(int start, boolean[] visited) {
        for (int next : graph.get(start)) {
            if (visited[next])
                continue;
            visited[next] = true;
            dfs(next, visited);
        }
        stack.add(start);
    }

    private static void dfsInv(int start, boolean[] visited) {
        for (int next : graphInv.get(start)) {
            if (visited[next])
                continue;
            visited[next] = true;
            dfsInv(next, visited);
        }
        scc.add(start);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
            graphInv.put(i, new ArrayList<>());
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graphInv.get(end).add(start);
        }
    }

    static class SCC implements Comparable<SCC> {
        private ArrayList<Integer> vertexes;

        SCC(ArrayList<Integer> v) {
            vertexes = new ArrayList<>();
            vertexes.addAll(v);
            vertexes.sort(null);
        }

        @Override
        public int compareTo(SCC s) {
            return this.vertexes.get(0) - s.vertexes.get(0);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int v : vertexes) {
                sb.append(v).append(" ");
            }
            return sb.toString();
        }
    }
}
