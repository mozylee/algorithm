package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class prob02493 {
    private static int N;

    private static int[] received;
    private static Tower[] towers;

    public static void main(String[] args) throws IOException {
        input();

        Stack<Tower> stack = new Stack<>();
        for (Tower tower : towers) {
            while (!stack.isEmpty() && stack.peek().height <= tower.height) {
                received[stack.peek().index] = tower.index;
                stack.pop();
            }
            stack.add(tower);
        }

        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(received[i] + 1).append(" ");
        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        received = new int[N];
        towers = new Tower[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            towers[N - i - 1] = new Tower(i, Integer.parseInt(st.nextToken()));
            received[i] = -1;
        }
    }

    private static final class Tower {
        int index, height;

        Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}
