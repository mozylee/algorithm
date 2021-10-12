package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob02075 {
    static int N;
    static int[][] values;

    public static void main(String[] args) throws IOException {
        input();

        PriorityQueue<Num> pq = new PriorityQueue<>();
        int[] tops = new int[N];
        for (int i = 0; i < N; i++) {
            pq.add(new Num(i, values[i][tops[i]++]));
        }

        int count = 0;
        int ans = 0;
        while (count++ < N) {
            Num min = pq.poll();
            ans = -min.value;
            if (tops[min.index] > N - 1) {
                return;
            }
            pq.add(new Num(min.index, values[min.index][tops[min.index]++]));
        }
        System.out.println(ans);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        values = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                values[j][N - 1 - i] = -Integer.valueOf(st.nextToken());
            }
        }
    }

    static class Num implements Comparable<Num> {
        int index, value;

        Num(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Num n) {
            return this.value - n.value;
        }
    }
}
