package boj;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob01525 {
    static final int SIZE = 3;
    static String board;
    static final String ANSWER = "123456780";

    public static void main(String[] args) {
        input();
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<>();
        queue.add(board);
        visited.put(board, 0);
        while (!queue.isEmpty()) {
            String now = queue.poll();
            if (now.equals(ANSWER)) {
                return visited.get(now);
            }
            int zero = now.indexOf('0');
            for (int i = 0; i <= SIZE; i++) {
                if (!canMove(zero, i))
                    continue;
                String next = transform(now, zero, i);
                if (next.equals(ANSWER)) {
                    return visited.get(now) + 1;
                }
                if (visited.containsKey(next))
                    continue;
                visited.put(next, visited.get(now) + 1);
                queue.add(next);
            }
        }
        return -1;
    }

    static String transform(String value, int zero, int direction) {
        StringBuilder next = new StringBuilder(value);
        int index = getIndex(zero, direction);
        next.setCharAt(index, '0');
        next.setCharAt(zero, value.charAt(index));
        return next.toString();
    }

    static int getIndex(int zero, int direction) {
        switch (direction) {
            case 0:
                return zero - 1;
            case 1:
                return zero - 3;
            case 2:
                return zero + 1;
            case 3:
                return zero + 3;
        }
        return -1;
    }

    static boolean canMove(int zero, int direction) {
        if (direction == 0 && zero % 3 == 0) {
            return false;
        }
        if (direction == 1 && zero / 3 < 1) {
            return false;
        }
        if (direction == 2 && zero % 3 == 2) {
            return false;
        }
        if (direction == 3 && zero / 3 > 1) {
            return false;
        }
        return true;
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < SIZE; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < SIZE; j++) {
                    sb.append(st.nextToken());
                }
            }
            board = sb.toString();
        } catch (Exception e) {
            System.out.println("ERROR!!!!");
        }
    }
}
