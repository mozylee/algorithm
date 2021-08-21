package boj;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class prob11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N, L;
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Value> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.peekFirst().index < i - L + 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast().value > number) {
                deque.pollLast();
            }
            deque.addLast(new Value(number, i));
            sb.append(deque.peekFirst());
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static class Value implements Comparable<Value> {
        int value, index;

        Value(int v, int i) {
            value = v;
            index = i;
        }

        @Override
        public int compareTo(Value v) {
            return this.value - v.value;
        }

        @Override
        public String toString() {
            return this.value + " ";
        }
    }
}
