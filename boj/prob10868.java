package boj;

import java.io.*;
import java.util.*;

/// UNSOLVED!!!!!!!!!!
public class prob10868 {
    static int N, M, size;
    static final int SIZE = (int) Math.pow(2, 20);
    static int[] tree = new int[SIZE * 2];

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        input();
        for (int i = 0; i < M; i++) {
            int[] query = getQuery();
            sb.append(getMin(query[0], query[1])).append('\n');
        }
        System.out.println(sb);
    }

    static int getMin(int start, int end) {
        start += SIZE;
        end += SIZE;

        int min = Math.min(tree[start], tree[end]);
        while (start <= end) {
            if (start % 2 == 0)
                min = Math.min(min, tree[start++]);
            if (end % 2 == 1)
                min = Math.min(min, tree[end--]);
            start /= 2;
            end /= 2;
        }
        return min;
    }

    static void update(int index, int value) {
        index += SIZE;
        tree[index] = value;
        int mid = index / 2;
        while (mid > 1) {
            tree[mid] = Math.min(tree[2 * mid], tree[2 * mid + 1]);
            mid /= 2;
        }
    }

    static int[] getQuery() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] query = new int[2];
            for (int i = 0; i < query.length; i++)
                query[i] = Integer.parseInt(st.nextToken());
            return query;
        } catch (Exception e) {
            return null;
        }
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++)
                update(i, Integer.parseInt(br.readLine()));
        } catch (Exception e) {
        }
    }
}
