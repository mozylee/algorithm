package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob02458 {
    static int N;
    static boolean[][] map;

    public static void main(String[] args) {
        input();
        floydWashall();
        System.out.println(getStudentAmount());
    }

    static int getStudentAmount() {
        int amount = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                if (!map[i][j] && !map[j][i]) {
                    count++;
                }
            }
            if (count < 1)
                amount++;
        }
        return amount;
    }

    static void floydWashall() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][k] && map[k][j])
                        map[i][j] = true;
                }
            }
        }
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            map = new boolean[N][N];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                map[from][to] = true;
            }
        } catch (Exception e) {
            System.out.println("ERROR!!!");
        }
    }
}
