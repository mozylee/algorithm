package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class prob10292 {
    private static int V, E;
    private static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static int[] levels;
    private static int level;
    private static boolean flag;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static final String YES = "YES", NO = "NO";

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int k = 0; k < T; k++) {
            input();

            level = 0;
            flag = false;
            levels = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                if (levels[i] > 0) {
                    continue;
                }
                if (dfs(i, true) == 0) {
                    break;
                }
            }

            sb.append(flag ? YES : NO).append("\n");
            graph.clear();
        }
        System.out.println(sb);
    }

    private static int dfs(int now, boolean isRoot) {
        if (flag) {
            return 0;
        }
        levels[now] = ++level;
        int ret = levels[now];
        int child = 0;
        for (int next : graph.get(now)) {
            if (levels[next] > 0) {
                ret = Math.min(ret, levels[next]);
                continue;
            }
            child++;
            int row = dfs(next, false);
            ret = Math.min(ret, row);
            if (!isRoot && levels[now] <= row) {
                flag = true;
                return 0;
            }
        }
        if (isRoot && child > 1) {
            flag = true;
        }
        return ret;
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
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
}
