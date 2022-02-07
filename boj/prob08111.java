package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class prob08111 {
    private static final int MAX_LENGTH = 100;
    private static boolean[] visited = new boolean[20000 + 1];
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(N > 1 ? bfs(N) : 1).append("\n");
        }
        System.out.println(sb);
    }

    private static String bfs(int N) {
        Arrays.fill(visited, false);
        Queue<Trial> queue = new LinkedList<>();
        queue.add(new Trial());
        Trial now;
        Trial[] next = new Trial[2];
        while (!queue.isEmpty()) {
            now = queue.poll();
            if (now.length >= MAX_LENGTH) {
                continue;
            }
            for (int i = 0; i < 2; i++) {
                next[i] = new Trial(now, i, N);
                if (visited[next[i].remainder]) {
                    continue;
                }
                visited[next[i].remainder] = true;
                if (next[i].remainder == 0) {
                    return next[i].toString();
                }
                queue.add(next[i]);
            }
        }
        return "BRAK";
    }

    static class Trial {
        int length;
        int remainder;
        char[] num;

        Trial() {
            num = new char[1];
            num[length++] = '1';
            remainder = 1;
        }

        Trial(Trial before, int next, int N) {
            this.num = Arrays.copyOf(before.num, before.length + 1);
            this.length = before.length;
            this.remainder = (before.remainder * 10 + next) % N;
            num[length++] = (char) (next + '0');
        }

        @Override
        public String toString() {
            return String.valueOf(num);
        }
    }
}
