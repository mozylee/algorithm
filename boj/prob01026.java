package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob01026 {
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(getMinSum());
    }

    private static long getMinSum() {
        long sum = 0;
        while (!minHeap.isEmpty()) {
            sum += minHeap.poll() * maxHeap.poll();
        }
        return sum;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            maxHeap.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            minHeap.add(Integer.parseInt(st.nextToken()));
        }
    }
}
