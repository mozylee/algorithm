package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob05014 {
    private static int F, S, G, U, D;

    public static void main(String[] args) {
        input();
        int count = bfs();
        System.out.println(count >= 0 ? count : "use the stairs");
    }

    private static int bfs() {
        if (S == G) {
            return 0;
        }
        boolean[] visited = new boolean[F + 1];
        Queue<Trial> queue = new LinkedList<>();
        visited[S] = true;
        queue.add(new Trial(S, 0));
        while (!queue.isEmpty()) {
            Trial now = queue.poll();
            int[] upAndDown = { now.floor + U, now.floor - D };
            for (int f : upAndDown) {
                if (isOutOfBounds(f) || visited[f])
                    continue;
                visited[f] = true;
                if (f == G)
                    return now.count + 1;
                queue.add(new Trial(f, now.count + 1));
            }
        }
        return -1;
    }

    private static boolean isOutOfBounds(int floor) {
        return 1 > floor || floor > F;
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            F = Integer.valueOf(st.nextToken());
            S = Integer.valueOf(st.nextToken());
            G = Integer.valueOf(st.nextToken());
            U = Integer.valueOf(st.nextToken());
            D = Integer.valueOf(st.nextToken());
        } catch (Exception e) {
            System.out.println("INPUT ERROR!");
        }
    }

    static class Trial {
        int floor, count;

        Trial(int floor, int count) {
            this.floor = floor;
            this.count = count;
        }
    }
}
