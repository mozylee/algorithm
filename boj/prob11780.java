package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// UNSOLVED!!!!
public class prob11780 {
    private static int N;
    private static int[][] map;
    private static int[][] route;

    public static void main(String[] args) throws IOException {
        input();

        floydWarshall();

        StringBuilder sb = new StringBuilder();
        printMap(sb);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                printRoute(i, j, sb);
            }
        }

        System.out.print(sb);
    }

    private static void floydWarshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j || map[i][k] == 0 || map[k][j] == 0) {
                        continue;
                    }

                    if (map[i][j] == 0 || map[i][k] + map[k][j] < map[i][j]) {
                        route[i][j] = k;
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
    }

    private static void printMap(StringBuilder sb) {
        for (int i = 1; i <= map.length; i++) {
            for (int j = 1; j <= map.length; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    private static void printRoute(int i, int j, StringBuilder sb) {
        if (map[i][j] == 0) {
            sb.append(0).append("\n");
            return;
        }

        // Stack<Integer> stack = new Stack<>();

        
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        route = new int[N + 1][N + 1];

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[start][end] = cost;
        }
    }

}
