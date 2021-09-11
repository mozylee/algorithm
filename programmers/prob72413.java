package programmers;

import java.util.Arrays;

public class prob72413 {
    static final int MAX_VALUE = 1_000_000;
    static int[][] graph;

    public static void main(String[] args) {
        int[] n = { 6, 7, 6 }, s = { 4, 3, 4 }, a = { 6, 4, 5 }, b = { 2, 1, 6 };
        int[][][] fares = {
                { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 }, { 2, 4, 66 },
                        { 2, 3, 22 }, { 1, 6, 25 } },
                { { 5, 7, 9 }, { 4, 6, 4 }, { 3, 6, 1 }, { 3, 2, 3 }, { 2, 1, 6 } }, { { 2, 6, 6 }, { 6, 3, 7 },
                        { 4, 6, 7 }, { 6, 5, 11 }, { 2, 5, 12 }, { 5, 3, 20 }, { 2, 4, 8 }, { 4, 3, 9 } } };
        for (int i = 0; i < fares.length; i++) {
            System.out.println(s[i] + ", " + a[i] + ", " + b[i]);
            System.out.println();
            System.out.println(solution(n[i], s[i], a[i], b[i], fares[i]));
        }
    }

    static void print() {
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph.length; j++) {
                System.out.print((graph[i][j] < MAX_VALUE ? graph[i][j] : "-") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        makeGraph(n, fares);
        print();
        floyd(n);
        print();
        int min = graph[s][a] + graph[s][b];
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, graph[s][i] + graph[i][a] + graph[i][b]);
        }
        return min;
    }

    static void floyd(int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = graph[j][i] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }
    }

    static void makeGraph(int n, int[][] fares) {
        graph = new int[n + 1][n + 1];
        Arrays.stream(graph).forEach(line -> Arrays.fill(line, MAX_VALUE));
        for (int[] fare : fares) {
            int i = fare[0], j = fare[1];
            int distance = Math.min(graph[i][j], fare[2]);
            graph[i][j] = graph[j][i] = distance;
        }
    }
}
