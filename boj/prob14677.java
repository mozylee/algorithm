package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// UNSOLVED!!!!!!!!!!!!!!!
public class prob14677 {
    private static int N;
    private static final int B = 0, L = 1, D = 2;

    private static int[] drugs;

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(bfs());
    }

    private static int bfs() {
        int count = 0;

        Queue<Trial> queue = new LinkedList<>();
        queue.add(new Trial(0, 3 * N - 1, 0));

        while (!queue.isEmpty()) {
            System.out.println(queue);
            Trial now = queue.poll();
            System.out.println(now);
            if (drugs[now.head] != now.time % 3) {
                count = Math.max(count, now.time);
            } else {
                if (now.head + 1 >= now.tail) {
                    count = Math.max(count, now.time + 1);
                } else {
                    queue.add(new Trial(now.head + 1, now.tail, now.time + 1));
                }
            }

            if (drugs[now.tail] != now.time % 3) {
                count = Math.max(count, now.time);
            } else {
                if (now.tail - 1 <= now.head) {
                    count = Math.max(count, now.time + 1);
                } else {
                    queue.add(new Trial(now.tail, now.tail - 1, now.time + 1));
                }
            }
        }
        return count;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        drugs = new int[3 * N];
        String line = br.readLine();
        for (int i = 0; i < 3 * N; i++) {
            drugs[i] = line.charAt(i) == 'B' ? B : line.charAt(i) == 'L' ? L : D;
        }
    }

    private static class Trial {
        int head, tail, time;

        Trial(int head, int tail, int time) {
            this.head = head;
            this.tail = tail;
            this.time = time;
        }

        @Override
        public String toString() {
            return "(" + head + ", " + tail + " : " + time + ")";
        }
    }
}