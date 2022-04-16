package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob21940 {
    private static int N, M, K;

    private static int[][] map;
    private static int[] friends;

    private static final int MAX_TIME = 10_000_000;

    public static void main(String[] args) throws IOException {
        input();

        floydWarshall();

        int min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int maxRoundTime = getMaxRoundTime(i);
            if (min > maxRoundTime) {
                min = maxRoundTime;
                sb.setLength(0);
            }
            if (min == maxRoundTime) {
                sb.append(i + 1).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static void floydWarshall() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }

    private static int getMaxRoundTime(int i) {
        int maxRoundTime = 0;
        for (int friend : friends) {
            maxRoundTime = Math.max(maxRoundTime, map[friend][i] + map[i][friend]);
        }
        return maxRoundTime;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], MAX_TIME);
            map[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int T = Integer.parseInt(st.nextToken());

            map[A][B] = Math.min(map[A][B], T);
        }

        K = Integer.parseInt(br.readLine());
        friends = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            friends[i] = Integer.parseInt(st.nextToken()) - 1;
        }
    }
}
