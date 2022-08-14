package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob14427 {
    private static int N;
    private static HashMap<Integer, Integer> values = new HashMap<>();
    private static PriorityQueue<Value> heap = new PriorityQueue<>();

    private static ArrayList<StringTokenizer> queries = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();

        StringBuilder sb = new StringBuilder();
        for (StringTokenizer query : queries) {
            if (query.nextToken().equals("2")) {
                while (isChanged(heap.peek())) {
                    heap.poll();
                }
                sb.append(heap.peek().index + 1).append("\n");
                continue;
            }
            int index = Integer.parseInt(query.nextToken()) - 1;
            int value = Integer.parseInt(query.nextToken());

            if (value == values.get(index)) {
                continue;
            }
            values.put(index, value);
            heap.add(new Value(index, value));
        }
        System.out.print(sb);
    }

    private static boolean isChanged(Value v) {
        return values.get(v.index) != v.value;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            values.put(i, Integer.parseInt(st.nextToken()));
            heap.add(new Value(i, values.get(i)));
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            queries.add(new StringTokenizer(br.readLine()));
        }
    }

    private static class Value implements Comparable<Value> {
        int index;
        int value;

        Value(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Value v) {
            return this.value == v.value
                    ? Integer.compare(this.index, v.index)
                    : Integer.compare(this.value, v.value);
        }
    }
}
