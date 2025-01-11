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

// G3: DP, Tree, Tree DP
public class prob02533 {

    public static void main(String[] args) throws IOException {
        Response response = getResponse();

        int result = calculate(response.tree);

        System.out.println(result);
    }

    private static int calculate(Map<Integer, List<Integer>> tree) {
        Set<Integer> visited = new HashSet<>();

        visited.add(1);
        Amount amount = dfs(1, tree, visited);

        return Math.min(amount.earlyAdaptor, amount.lateAdaptor);
    }

    private static Amount dfs(
            int node, Map<Integer, List<Integer>> tree, Set<Integer> visited
    ) {
        int ealry = 0;
        int late = 0;

        for (int next : tree.get(node)) {
            if (visited.contains(next)) {
                continue;
            }

            visited.add(next);
            Amount nextAmount = dfs(next, tree, visited);

            ealry += nextAmount.earlyAdaptor;
            late += Math.min(nextAmount.earlyAdaptor, nextAmount.lateAdaptor);
        }

        if (ealry == 0 && late == 0) {
            return new Amount(1, 0);
        }

        return new Amount(Math.min(ealry, late) + 1, ealry);
    }

    private static Response getResponse() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        StringTokenizer st;
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
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

        return new Response(tree);
    }

    private static final class Response {

        Map<Integer, List<Integer>> tree;

        public Response(Map<Integer, List<Integer>> tree) {
            this.tree = tree;
        }
    }

    private static final class Amount {

        int earlyAdaptor;
        int lateAdaptor;

        public Amount(int earlyAdaptor, int lateAdaptor) {
            this.earlyAdaptor = earlyAdaptor;
            this.lateAdaptor = lateAdaptor;
        }
    }

}
