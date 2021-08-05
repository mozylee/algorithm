package boj;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob09466 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, cycle;
    static int[] students, visited;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            input();
            for (int j = 0; j < n; j++)
                if (visited[j] == 0)
                    dfs(j, 1);
            sb.append(n - cycle).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int x, int count) {
        if (visited[x] == -1 || count > n) {
            return;
        }
        visited[x] = count;
        if (visited[students[x]] > 0) {
            cycle += count - visited[students[x]] + 1;
            visited[x] = -1;
            return;
        }
        dfs(students[x], count + 1);
        visited[x] = -1;
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        cycle = 0;
        students = new int[n];
        visited = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < students.length; i++) {
            students[i] = Integer.parseInt(st.nextToken()) - 1;
        }
    }
}
