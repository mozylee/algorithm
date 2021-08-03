package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob14889 {
    static int N, gap = Integer.MAX_VALUE;
    static int[][] stats;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        isSelected = new boolean[N];
        stats = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (i < j)
                    stats[i][j] = Integer.parseInt(st.nextToken());
                else
                    stats[j][i] += Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(gap);
    }

    public static void dfs(int select, int count) {
        if (count == N / 2) {
            gap = Math.min(gap, Math.abs(getSum(true) - getSum(false)));
            return;
        }
        for (int i = select; i < N; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                dfs(i, count + 1);
                isSelected[i] = false;
            }
        }
    }

    public static int getSum(boolean isLink) {
        int sum = 0;
        int[] team = new int[N / 2];
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (isSelected[i] == isLink)
                team[count++] = i;
        }
        for (int i = 0; i < N / 2 - 1; i++) {
            for (int j = i + 1; j < N / 2; j++) {
                sum += stats[team[i]][team[j]];
            }
        }
        return sum;
    }
}
