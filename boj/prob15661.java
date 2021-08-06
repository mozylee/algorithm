package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob15661 {
    static int N, gap = Integer.MAX_VALUE;
    static int[][] stats;
    static boolean[] isSelected;
    public static void main(String[] args) {
        input();
        dfs(0, 0);
        System.out.println(gap);
    }

    public static void dfs(int select, int count) {
        if (count == N / 2 + 1)
            return;
        if (count > 1) {
            gap = Math.min(gap, getDifference(count));
            if (gap == 0) {
                System.out.println(0);
                System.exit(0);
            }
        }
        for (int i = select; i < N; i++)
            if (!isSelected[i]) {
                isSelected[i] = true;
                dfs(i, count + 1);
                isSelected[i] = false;
            }
    }

    public static int getDifference(int count) {
        int result = 0;
        for (int i = 0; i < N - 1; i++)
            for (int j = i + 1; j < N; j++)
                if (!(isSelected[i] ^ isSelected[j]))
                    result += isSelected[i] ? stats[i][j] : -stats[i][j];
        return Math.abs(result);
    }

    public static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            isSelected = new boolean[N];
            stats = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    if (i < j)
                        stats[i][j] = Integer.parseInt(st.nextToken());
                    else
                        stats[j][i] += Integer.parseInt(st.nextToken());
            }
        } catch (Exception e) {
            System.out.println("ERROR!");
        }

    }
}
