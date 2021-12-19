package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class prob01744 {
    static PriorityQueue<Integer> positives = new PriorityQueue<>();
    static PriorityQueue<Integer> negatives = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        input();
        int sum = 0;
        while (!negatives.isEmpty()) {
            int num1 = negatives.poll();
            int num2 = negatives.isEmpty() ? 1 : negatives.poll();
            sum += num1 * num2;
        }
        while (!positives.isEmpty()) {
            int num1 = -positives.poll();
            int num2 = positives.isEmpty() || positives.peek() == -1 ? 1 : -positives.poll();
            sum += num1 * num2;
        }
        System.out.println(sum);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.valueOf(br.readLine());
            if (value > 0) {
                positives.add(-value);
            } else {
                negatives.add(value);
            }
        }
    }
}
