package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob01202 {
    private static PriorityQueue<Integer> bags = new PriorityQueue<>();
    private static LinkedList<Jewelry> jewelryList = new LinkedList<>();

    private static PriorityQueue<Jewelry> jewelries = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        input();

        long sum = 0;

        while (!bags.isEmpty()) {
            int bag = bags.poll();

            while (!jewelryList.isEmpty() && jewelryList.peek().m <= bag) {
                jewelries.add(jewelryList.poll());
            }

            sum += !jewelries.isEmpty() ? jewelries.poll().v : 0;
        }

        System.out.println(sum);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewelryList.add(new Jewelry(m, v));
        }

        jewelryList.sort(new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry j1, Jewelry j2) {
                return j1.m - j2.m;
            }
        });

        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }
    }

    private static final class Jewelry implements Comparable<Jewelry> {
        int m, v;

        Jewelry(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Jewelry j) {
            if (this.v == j.v) {
                return this.m - j.m;
            }
            return -(this.v - j.v);
        }
    }
}
