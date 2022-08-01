package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class prob06416 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static HashMap<Integer, Integer> indegrees = new HashMap<>();
    private static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

    private static int root;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 1;; i++) {
            boolean flag = input();
            root = -1;
            sb.append("Case ")
                    .append(i)
                    .append(" is ")
                    .append(isTree() ? "" : "not ")
                    .append("a tree.\n");

            indegrees.clear();
            graph.clear();
            if (flag) {
                break;
            }
        }

        System.out.print(sb);
    }

    private static boolean isTree() {
        System.out.println(indegrees);
        System.out.println(graph);
        return countDegrees() && dfs(root) == indegrees.size();
    }

    private static int dfs(int now) {
        if (now == -1) {
            return 0;
        }

        if (!graph.containsKey(now)) {
            return 1;
        }

        int count = 1;
        for (int next : graph.get(now)) {
            count+=dfs(next);
        }

        return count;
    }

    private static boolean countDegrees() {
        if (indegrees.isEmpty()) {
            return true;
        }

        int rootCount = 0;
        for (int key : indegrees.keySet()) {
            if (indegrees.get(key) > 1) {
                return false;
            } else if (indegrees.get(key) == 0) {
                root = key;
                rootCount++;
            }
        }

        return rootCount == 1;
    }

    private static boolean input() throws IOException {
        StringTokenizer st;

        boolean flag = false;
        while (true) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (a == -1 && b == -1) {
                    return true;
                }
                if (a == 0 && b == 0) {
                    flag = true;
                    break;
                }

                if (!indegrees.containsKey(a)) {
                    indegrees.put(a, 0);
                }
                if (!indegrees.containsKey(b)) {
                    indegrees.put(b, 0);
                }
                if (!graph.containsKey(a)) {
                    graph.put(a, new ArrayList<>());
                }

                indegrees.put(b, indegrees.get(b) + 1);
                graph.get(a).add(b);
            }

            if (flag) {
                break;
            }
        }

        return false;
    }
}
