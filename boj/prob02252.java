package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob02252 {
    private static int N, M;
    private static HashMap<Integer, ArrayList<Integer>> graph;
    private static HashMap<Integer, Integer> cardinality;

    public static void main(String[] args) throws IOException {
        init();
        StringBuilder sb = new StringBuilder();
        Queue<Integer> zeroCards = new LinkedList<>();
        cardinality.forEach((k, v) -> {
            if (v == 0)
                zeroCards.add(k);
        });
        while (!zeroCards.isEmpty()) {
            int shorter = zeroCards.poll();
            sb.append(shorter).append(" ");

            graph.get(shorter).forEach(taller -> {
                cardinality.put(taller, cardinality.get(taller) - 1);
                if (cardinality.get(taller) == 0) {
                    zeroCards.add(taller);
                }
            });
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        initGraph();
        initCardinality();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int shorter = Integer.valueOf(st.nextToken());
            int taller = Integer.valueOf(st.nextToken());
            graph.get(shorter).add(taller);
            cardinality.put(taller, cardinality.get(taller) + 1);
        }
    }

    private static void initCardinality() {
        cardinality = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            cardinality.put(i, 0);
        }
    }

    private static void initGraph() {
        graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }
    }
}
