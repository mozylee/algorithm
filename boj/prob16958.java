package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob16958 {
    private static int N, M, T;
    private static City[] cities;
    private static int[][] queries;
    private static int[][] distances;

    private static final int INF = 10_000_000;

    public static void main(String[] args) throws IOException {
        input();

        floydWarshall();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(distances[queries[i][0]][queries[i][1]]).append("\n");
        }
        System.out.println(sb);
    }

    private static void floydWarshall() {
        distances = new int[N][N];
        initDistances();
        
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                }
            }
        }
    }

    private static void initDistances() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j || distances[i][j] > 0) {
                    continue;
                }
                int distance = Math.abs(cities[i].x - cities[j].x) + Math.abs(cities[i].y - cities[j].y);
                distance = Math.min(distance,
                        cities[i].isSpecial && cities[j].isSpecial ? T : INF);

                distances[i][j] = distance;
                distances[j][i] = distance;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        cities = new City[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            cities[i] = new City(x, y, s);
        }

        M = Integer.parseInt(br.readLine());

        queries = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                queries[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }
    }

    private static final class City {
        int x, y;
        boolean isSpecial;

        City(int x, int y, int s) {
            this.x = x;
            this.y = y;
            isSpecial = s == 1;
        }
    }
}
