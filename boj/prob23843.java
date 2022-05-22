package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob23843 {
    private static int N, M;
    private static int[] electronics;

    public static void main(String[] args) throws IOException {
        input();
        int time = 0;
        int index = N - 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < Math.min(M, N) - 1; i++) {
            pq.add(0);
        }

        while (index >= 0) {
            pq.add(electronics[index--] + pq.poll());
        }
        while (!pq.isEmpty()) {
            time = Math.max(pq.poll(), time);
        }
        System.out.println(time);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        electronics = new int[N];
        for (int i = 0; i < N; i++) {
            electronics[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(electronics);
    }
}