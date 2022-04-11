package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class prob01506 {
    private static int N;
    private static int[] costs;

    private static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static HashMap<Integer, ArrayList<Integer>> graphInv = new HashMap<>();

    private static boolean[] visited;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        input();
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            dfs(i, false);
        }

        visited = new boolean[N + 1];
        int sum = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            sum += visited[node] ? 0 : dfs(node, true);
        }
        System.out.println(sum);
    }

    private static int dfs(int now, boolean isInversed) {
        if (visited[now]) {
            return Integer.MAX_VALUE;
        }
        visited[now] = true;

        int min = costs[now];
        for (int next : isInversed ? graphInv.get(now) : graph.get(now)) {
            min = Math.min(min, dfs(next, isInversed));
        }

        if (!isInversed) {
            stack.push(now);
        }
        return min;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        costs = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
            graphInv.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                if (line.charAt(j - 1) == '0') {
                    continue;
                }
                graph.get(i).add(j);
                graphInv.get(j).add(i);
            }
        }
    }
}
