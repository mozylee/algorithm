package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob18513 {
    private static int K;
    private static Queue<Trial> queue = new LinkedList<>();
    private static HashSet<Integer> visited = new HashSet<>();
    private static int next;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs());
    }

    private static long bfs() {
        int count = 0;
        long unhappy = 0;
        while (!queue.isEmpty()) {
            Trial now = queue.poll();
            for (int i = -1; i <= 1; i += 2) {
                next = now.location + i;
                if (visited.contains(next)) {
                    continue;
                }
                visited.add(next);
                count++;
                unhappy += now.distance + 1;
                queue.add(new Trial(next, now.distance + 1));
                if (count == K)
                    return unhappy;
            }
        }
        return unhappy;
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int location = Integer.valueOf(st.nextToken());
            queue.add(new Trial(location, 0));
            visited.add(location);
        }
    }

    static class Trial {
        int location, distance;

        Trial(int location, int distance) {
            this.location = location;
            this.distance = distance;
        }
    }
}
