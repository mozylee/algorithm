package boj;

import java.io.*;
import java.util.*;

public class prob18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            boolean nextLine = true;
            switch (input) {
                case "push":
                    deque.add(Integer.parseInt(st.nextToken()));
                    nextLine = false;
                    break;
                case "pop":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.pollFirst());
                    }
                    break;
                case "size":
                    sb.append(deque.size());
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.peekFirst());
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.peekLast());
                    }
                    break;
            }
            sb.append(nextLine ? '\n' : "");
        }
        System.out.println(sb);
    }
}
