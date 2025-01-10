package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

// G4: DP, Tree DP, Graph, DFS
public class prob14267 {

    public static void main(String[] args) throws IOException {
        Response response = getResponse();

        Map<Integer, Integer> result = calculate(response.tree, response.compliments);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= result.keySet().size(); i++) {
            sb.append(result.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    private static Map<Integer, Integer> calculate(Map<Integer, List<Integer>> tree, Map<Integer, Integer> compliments) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> result = new HashMap<>();

        visited.add(1);
        dfs(1, 0, tree, visited, compliments, result);

        return result;
    }

    private static void dfs(
            int node, int compliment, Map<Integer, List<Integer>> tree, Set<Integer> visited,
            Map<Integer, Integer> compliments, Map<Integer, Integer> result
    ) {
        int nextCompliment = compliment + compliments.getOrDefault(node, 0);
        result.put(node, nextCompliment);

        for (int next : tree.get(node)) {
            if (visited.contains(next)) {
                continue;
            }

            visited.add(next);
            dfs(next, nextCompliment, tree, visited, compliments, result);
        }
    }

    private static Response getResponse() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> tree = new HashMap<>();
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                st.nextToken();
                continue;
            }

            int u = Integer.parseInt(st.nextToken());

            if (!tree.containsKey(u)) {
                tree.put(u, new ArrayList<>());
            }
            if (!tree.containsKey(i + 1)) {
                tree.put(i + 1, new ArrayList<>());
            }

            tree.get(u).add(i + 1);
            tree.get(i + 1).add(u);
        }

        Map<Integer, Integer> compliments = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int worker = Integer.parseInt(st.nextToken());
            int compliment = Integer.parseInt(st.nextToken());

            if (!compliments.containsKey(worker)) {
                compliments.put(worker, 0);
            }
            compliments.put(worker, compliments.get(worker) + compliment);
        }

        return new Response(tree, compliments);
    }

    private static final class Response {

        Map<Integer, List<Integer>> tree;
        Map<Integer, Integer> compliments;

        public Response(Map<Integer, List<Integer>> tree, Map<Integer, Integer> compliments) {
            this.tree = tree;
            this.compliments = compliments;
        }
    }

}
