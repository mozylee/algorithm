package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob16198 {
    private static int N;
    private static int[] energies;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(dfs(0, 0));
    }

    private static long dfs(int count, long sum) {
        if (count > N - 2) {
            return 0;
        }

        long max = 0;
        for (int i = 1; i < N - 1; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            max = Math.max(max, dfs(count + 1, getSum(i)));
            visited[i] = false;
        }

        return sum + max;
    }

    private static long getSum(int now) {
        int left = now - 1, right = now + 1;

        while (visited[left]) {
            left--;
        }

        while (visited[right]) {
            right++;
        }

        return energies[left] * energies[right];
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        energies = new int[N];
        for (int i = 0; i < N; i++) {
            energies[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
    }
}
