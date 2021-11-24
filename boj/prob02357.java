package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob02357 {
    private static int[] minTree;
    private static int[] maxTree;
    private static int level, first;
    private static int N, M;
    private static final boolean MIN = true, MAX = false;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        input();
        minTree[1] = initMin(1);
        maxTree[1] = initMax(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken()) - 1;
            int end = Integer.valueOf(st.nextToken()) - 1;
            sb.append(getValue(start, end, MIN)).append(" ").append(getValue(start, end, MAX)).append("\n");
        }
        System.out.println(sb);
    }

    private static int getValue(int start, int end, boolean isMin) {
        int left = start + first;
        int right = end + first;

        int ret = isMin ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        while (left <= right) {
            if (left % 2 == 1) {
                ret = isMin ? Math.min(ret, minTree[left++]) : Math.max(ret, maxTree[left++]);
            }
            if (right % 2 == 0) {
                ret = isMin ? Math.min(ret, minTree[right--]) : Math.max(ret, maxTree[right--]);
            }
            left /= 2;
            right /= 2;
        }
        return ret;
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        level = (int) Math.ceil(Math.log(N) / Math.log(2));
        first = 1 << (level);
        minTree = new int[1 << (level + 1)];
        maxTree = new int[1 << (level + 1)];
        for (int i = 0; i < N; i++) {
            int value = Integer.valueOf(br.readLine());
            minTree[first + i] = value;
            maxTree[first + i] = value;
        }
    }

    private static int initMin(int node) {
        if (node >= first) {
            return minTree[node];
        }
        minTree[node * 2] = initMin(node * 2);
        minTree[node * 2 + 1] = initMin(node * 2 + 1);
        return Math.min(minTree[node * 2], minTree[node * 2 + 1]);
    }

    private static int initMax(int node) {
        if (node >= first) {
            return maxTree[node];
        }
        maxTree[node * 2] = initMax(node * 2);
        maxTree[node * 2 + 1] = initMax(node * 2 + 1);
        return Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
    }
}
