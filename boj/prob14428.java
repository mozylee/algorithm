package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob14428 {
    private static Num[] tree;
    private static int level, first;
    private static int N, M;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        input();
        tree[1] = init(1);
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            boolean op = Integer.valueOf(st.nextToken()) == 1;
            int i = Integer.valueOf(st.nextToken()) - 1;
            int j = Integer.valueOf(st.nextToken());
            if (op) {
                update(i, j);
            } else {
                sb.append(getMinIndex(i, j - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void update(int index, int value) {
        int i = index + first;
        tree[i].change(value);
        while (i > 1) {
            i /= 2;
            tree[i] = min(tree[i * 2], tree[i * 2 + 1]);
        }
    }

    private static int getMinIndex(int start, int end) {
        int left = start + first;
        int right = end + first;

        Num sum = new Num(Integer.MAX_VALUE, Integer.MAX_VALUE);
        while (left <= right) {
            if (left % 2 == 1) {
                sum = min(sum, tree[left++]);
            }
            if (right % 2 == 0) {
                sum = min(sum, tree[right--]);
            }
            left /= 2;
            right /= 2;
        }
        return sum.index;
    }

    private static void input() throws IOException {
        N = Integer.valueOf(br.readLine());
        level = (int) Math.ceil(Math.log(N) / Math.log(2));
        first = 1 << (level);
        st = new StringTokenizer(br.readLine());
        tree = new Num[1 << (level + 1)];
        Arrays.fill(tree, new Num(Integer.MAX_VALUE, Integer.MAX_VALUE));
        for (int i = 0; i < N; i++) {
            tree[first + i] = new Num(i + 1, Integer.valueOf(st.nextToken()));
        }
        M = Integer.valueOf(br.readLine());
    }

    private static Num init(int node) {
        if (node >= first) {
            return tree[node];
        }
        tree[node * 2] = init(node * 2);
        tree[node * 2 + 1] = init(node * 2 + 1);
        return min(tree[node * 2], tree[node * 2 + 1]);
    }

    private static Num min(Num n1, Num n2) {
        if (n1.value == n2.value) {
            return n1.index < n2.index ? n1 : n2;
        }
        return n1.value < n2.value ? n1 : n2;
    }

    static class Num {
        int index, value;

        public Num(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public void change(int value) {
            this.value = value;
        }
    }
}
