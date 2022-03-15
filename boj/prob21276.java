package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class prob21276 {
    private static int N;

    private static TreeSet<String> names = new TreeSet<>();
    private static TreeSet<String> progenitor = new TreeSet<>();

    private static HashMap<String, Integer> count = new HashMap<>();
    private static HashMap<String, Integer> levels = new HashMap<>();

    private static HashMap<String, ArrayList<String>> ancestors = new HashMap<>();
    private static HashMap<String, TreeSet<String>> childs = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();

        phaseSort();
        matchingParents();

        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(progenitor.size()).append("\n");
        for (String p : progenitor) {
            sb.append(p).append(" ");
        }
        sb.append("\n");

        for (String ancestor : names) {
            sb.append(ancestor).append(" ").append(childs.get(ancestor).size()).append(" ");
            for (String child : childs.get(ancestor)) {
                sb.append(child).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void matchingParents() {
        for (String child : names) {
            if (ancestors.get(child).size() == 0) {
                progenitor.add(child);
                continue;
            }
            String parent = getParent(ancestors.get(child));
            childs.get(parent).add(child);
        }
    }

    private static String getParent(ArrayList<String> candidates) {
        String minLevel = candidates.get(0);
        for (String candidate : candidates) {
            minLevel = levels.get(minLevel) < levels.get(candidate) ? minLevel : candidate;
        }

        return minLevel;
    }

    private static void phaseSort() {
        Queue<String> queue = new LinkedList<>();

        for (String name : count.keySet()) {
            if (count.get(name) > 0) {
                continue;
            }
            queue.add(name);
        }

        int level = 0;
        while (!queue.isEmpty()) {
            String name = queue.poll();
            levels.put(name, level++);

            for (String ancestor : ancestors.get(name)) {
                count.put(ancestor, count.get(ancestor) - 1);

                if (count.get(ancestor) > 0) {
                    continue;
                }
                queue.add(ancestor);
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            String name = st.nextToken();
            names.add(name);
            count.put(name, 0);
            ancestors.put(name, new ArrayList<>());
            childs.put(name, new TreeSet<>());
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String ancestor = st.nextToken();

            count.put(ancestor, count.get(ancestor) + 1);
            ancestors.get(child).add(ancestor);
        }
    }
}
