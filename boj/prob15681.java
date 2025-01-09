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

// G5: DP, Tree DP, Graph, DFS
public class prob15681 {

    public static void main(String[] args) throws IOException {
        Response response = getResponse();

        Map<Integer, Integer> subTreeNodes = calculate(response.root, response.tree);

        StringBuilder sb = new StringBuilder();
        for (int query : response.queries) {
            sb.append(subTreeNodes.get(query)).append("\n");
        }
        System.out.print(sb);
    }

    private static Map<Integer, Integer> calculate(int root, Map<Integer, List<Integer>> tree) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> subtreeNodes = new HashMap<>();

        visited.add(root);
        dfs(root, tree, visited, subtreeNodes);

        return subtreeNodes;
    }

    private static int dfs(int node, Map<Integer, List<Integer>> tree, Set<Integer> visited, Map<Integer, Integer> subtreeNodes) {
        int count = 1;
        for (int next : tree.get(node)) {
            if (visited.contains(next)) {
                continue;
            }

            visited.add(next);
            count += dfs(next, tree, visited, subtreeNodes);
        }

        subtreeNodes.put(node, count);

        return count;
    }

    private static Response getResponse() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (!tree.containsKey(u)) {
                tree.put(u, new ArrayList<>());
            }
            if (!tree.containsKey(v)) {
                tree.put(v, new ArrayList<>());
            }

            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        List<Integer> queries = new ArrayList<>(q);
        for (int i = 0; i < q; i++) {
            queries.add(Integer.parseInt(reader.readLine()));
        }

        return new Response(root, tree, queries);
    }

    private static final class Response {

        int root;
        Map<Integer, List<Integer>> tree;
        List<Integer> queries;

        public Response(int root, Map<Integer, List<Integer>> tree, List<Integer> queries) {
            this.root = root;
            this.tree = tree;
            this.queries = queries;
        }
    }

}
