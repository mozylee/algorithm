package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob20055 {
    private static int N, K, LENGTH;
    private static int[] durability;

    public static void main(String[] args) throws IOException {
        input();

        int turn = 0;
        int zeroCount = 0;

        boolean[] locations = new boolean[LENGTH];
        Queue<Integer> queue = new LinkedList<>();
        while (true) {
            // 1
            turn++;
            int start = ((LENGTH - 1) * turn) % (LENGTH);
            int end = (start + N - 1) % (LENGTH);

            // 2
            int size = queue.size();
            while (size-- > 0) {
                locations[queue.peek()] = false;
                int robot = queue.poll();
                if (robot == end) {
                    continue;
                }

                int next = (robot + 1) % LENGTH;
                if (durability[next] > 0 && !locations[next]) {
                    durability[next]--;
                    if (durability[next] == 0) {
                        zeroCount++;
                    }

                    robot = next;
                }
                if (robot == end) {
                    continue;
                }

                locations[robot] = true;
                queue.add(robot);
            }

            // 3
            if (durability[start] > 0) {
                durability[start]--;
                locations[start] = true;
                if (durability[start] == 0) {
                    zeroCount++;
                }
                queue.add(start);
            }

            // 4
            if (zeroCount >= K) {
                break;
            }
        }
        System.out.println(turn);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        LENGTH = 2 * N;

        st = new StringTokenizer(br.readLine());
        durability = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }
    }
}
