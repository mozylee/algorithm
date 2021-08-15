package boj;

import java.io.*;
import java.util.*;

public class prob05430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        Outter: for (int i = 0; i < T; i++) {
            boolean isReversed = false;
            String arguments = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<String> deque = new LinkedList<>();
            String input = br.readLine();
            st = new StringTokenizer(input.substring(1, input.length() - 1), ",");
            for (int j = 0; j < n; j++) {
                deque.add(st.nextToken());
            }
            for (int j = 0; j < arguments.length(); j++) {
                char arg = arguments.charAt(j);
                if (arg == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (!deque.isEmpty()) {
                        if (isReversed)
                            deque.pollLast();
                        else
                            deque.pollFirst();
                    } else {
                        sb.append("error\n");
                        continue Outter;
                    }
                }
            }
            sb.append(getResult(deque, isReversed)).append('\n');
        }
        System.out.println(sb);
    }

    static String getResult(Deque<String> d, boolean isReversed) {
        if (isReversed) {
            Collections.reverse((LinkedList<String>) d);
        }
        return "[" + String.join(",", d) + "]";
    }
}
