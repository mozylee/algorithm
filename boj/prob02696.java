package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob02696 {
    private static int N;
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    private static int num, min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer("");
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            sb.append((N + 1) / 2).append("\n");
            for (int j = 0; j < N; j++) {
                if (j % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                num = Integer.parseInt(st.nextToken());
                if (maxHeap.size() == minHeap.size()) {
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }

                if (!minHeap.isEmpty()) {
                    if (maxHeap.peek() > minHeap.peek()) {
                        max = maxHeap.poll();
                        min = minHeap.poll();

                        maxHeap.add(min);
                        minHeap.add(max);
                    }
                }

                if (j % 2 == 1) {
                    continue;
                }
                sb.append(maxHeap.peek());
                sb.append((j > 1 && j % 18 == 0) || j == N - 1 ? "\n" : " ");
            }
            maxHeap.clear();
            minHeap.clear();
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
