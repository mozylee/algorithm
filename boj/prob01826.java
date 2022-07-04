package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob01826 {
    private static int N, L, P;
    private static PriorityQueue<GasStation> gasStations = new PriorityQueue<>(new Comparator<GasStation>() {
        @Override
        public int compare(GasStation g1, GasStation g2) {
            return g1.location - g2.location;
        }
    });

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(drive());
    }

    private static int drive() {
        PriorityQueue<GasStation> pq = new PriorityQueue<>();
        int count = 0;
        int location = 0;

        while (!pq.isEmpty() || !gasStations.isEmpty()) {
            location += P;
            P = 0;

            if (location >= L) {
                return count;
            }

            while (!gasStations.isEmpty() && gasStations.peek().location <= location) {
                pq.add(gasStations.poll());
            }

            if (pq.isEmpty()) {
                return -1;
            }
            count++;
            P += pq.poll().fuel;
        }

        return -1;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            gasStations.add(new GasStation(l, f));
        }

        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
    }

    private static final class GasStation implements Comparable<GasStation> {
        int location, fuel;

        GasStation(int location, int fuel) {
            this.location = location;
            this.fuel = fuel;
        }

        @Override
        public int compareTo(GasStation g) {
            if (this.fuel == g.fuel) {
                return this.location - g.location;
            }
            return -(this.fuel - g.fuel);
        }
    }
}