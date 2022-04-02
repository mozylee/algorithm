package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob21939 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st = new StringTokenizer("");
    private static StringBuilder sb = new StringBuilder();

    private static HashMap<Integer, Integer> pMap = new HashMap<>();
    private static PriorityQueue<Problem> minHeap = new PriorityQueue<>();
    private static PriorityQueue<Problem> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    private static int id, difficulty, x;

    public static void main(String[] args) throws IOException {
        init();

        int P = Integer.parseInt(br.readLine());
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "add":
                    id = Integer.parseInt(st.nextToken());
                    difficulty = Integer.parseInt(st.nextToken());

                    add(id, difficulty);
                    break;

                case "solved":
                    id = Integer.parseInt(st.nextToken());

                    solve(id);
                    break;

                case "recommend":
                    x = Integer.parseInt(st.nextToken());

                    sb.append(x > 0 ? getDifficult() : getEasy()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }

    private static void add(int id, int difficulty) {
        Problem p = new Problem(id, difficulty);

        pMap.put(id, difficulty);
        minHeap.add(p);
        maxHeap.add(p);
    }

    private static void solve(int id) {
        pMap.remove(id);
    }

    private static int getDifficult() {
        while (canRecommand(maxHeap)) {
            maxHeap.poll();
        }
        return maxHeap.peek().P;
    }

    private static int getEasy() {
        while (canRecommand(minHeap)) {
            minHeap.poll();
        }
        return minHeap.peek().P;
    }

    private static boolean canRecommand(PriorityQueue<Problem> pq) {
        return !pMap.containsKey(pq.peek().P) || pMap.get(pq.peek().P) != pq.peek().L;
    }

    private static void init() throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            id = Integer.parseInt(st.nextToken());
            difficulty = Integer.parseInt(st.nextToken());

            add(id, difficulty);
        }
    }

    private static class Problem implements Comparable<Problem> {
        int P, L;

        Problem(int P, int L) {
            this.P = P;
            this.L = L;
        }

        @Override
        public int compareTo(Problem p) {
            return this.L == p.L ? this.P - p.P : this.L - p.L;
        } 
    }
}
