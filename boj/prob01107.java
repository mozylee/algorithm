package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class prob01107 {
    private static int N;
    private static HashSet<Integer> buttons = new HashSet<>();

    private static int num = 10_000_000;
    private static int count = 20_000_000;

    public static void main(String[] args) throws IOException {
        input();

        int maxCount = (N > 0 ? (int) Math.log10(N) : 0) + 2;
        dfs(0, 0, maxCount);
        System.out.println(Math.min(count + Math.abs(num - N), Math.abs(100 - N)));
    }

    private static void dfs(int now, int level, int maxCount) {
        if (level > 0 && (Math.abs(now - N) + level) < (Math.abs(num - N) + count)) {
            num = now;
            count = level;
            // System.out.println(num + " " + count);
        }
        if (level == maxCount) {
            return;
        }
        for (int next : buttons) {
            dfs(now * 10 + next, level + 1, maxCount);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 10; i++) {
            buttons.add(i);
        }

        int k = Integer.parseInt(br.readLine());
        if (k == 0) {
            return;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            buttons.remove(Integer.parseInt(st.nextToken()));
        }
    }
}
