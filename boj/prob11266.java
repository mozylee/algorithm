package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class prob11266 {
    private static int V, E;
    private static HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    private static int[] levels;
    private static int[] childs;
    private static int level;
    private static boolean[] isAP;

    public static void main(String[] args) throws IOException {
        input();
        childs = new int[V + 1];
        levels = new int[V + 1];
        isAP = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            if (levels[i] > 0) {
                continue;
            }
            dfs(i);
            isAP[i] = childs[i] > 1;
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (isAP[i]) {
                count++;
                sb.append(i).append(" ");
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }

    private static int dfs(int start) {
        levels[start] = ++level;
        int ret = levels[start];

        for (int child : graph.get(start)) {
            if (levels[child] > 0) {
                ret = Math.min(ret, levels[child]);
                continue;
            }
            childs[start]++;
            int row = dfs(child);
            if (levels[start] <= row) {
                isAP[start] = true;
            }
            ret = Math.min(ret, row);
        }
        return ret;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= V; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
    }
}