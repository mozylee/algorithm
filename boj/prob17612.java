package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob17612 {
    private static int N, k;

    private static PriorityQueue<Actor> counters = new PriorityQueue<>();
    private static PriorityQueue<Actor> customers = new PriorityQueue<>();

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int id = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Actor counter = counters.poll();

            counter.time += w;
            customers.add(new Actor(-counter.n, counter.time, id));
            counters.add(counter);
        }

        BigInteger ans = BigInteger.ZERO;
        for (int i = 0; i < N; i++) {
            ans = ans.add(BigInteger.valueOf(i+1).multiply(BigInteger.valueOf(customers.poll().id)));
        }
        System.out.println(ans);
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            counters.add(new Actor(i));
        }
    }

    private static final class Actor implements Comparable<Actor> {
        int n, time, id;

        Actor(int n) {
            this.n = n;
            time = 0;
        }

        Actor(int n, int time, int id) {
            this(n);
            this.time += time;
            this.id = id;
        }

        @Override
        public int compareTo(Actor a) {
            if (this.time == a.time) {
                return this.n - a.n;
            }
            return this.time - a.time;
        }

        @Override
        public String toString() {
            return "(" + this.id + " : " + this.time + "," + (-n) + ")";
        }
    }
}
