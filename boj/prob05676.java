package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob05676 {
    private static int[] tree;
    private static int level, first;
    private static int N, M;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static final char[] ret = { '-', '0', '+' };

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!input())
                break;
            tree[1] = init(1);
            sb.append(Arrays.toString(tree)).append("\n");
            for (int k = 0; k < M; k++) {
                st = new StringTokenizer(br.readLine());
                boolean op = st.nextToken().equals("C");
                int i = Integer.valueOf(st.nextToken()) - 1;
                int j = Integer.valueOf(st.nextToken());
                if (op) {
                    update(i, makeSimple(j));
                } else {
                    sb.append(multiply(i, j - 1));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static char multiply(int start, int end) {
        int left = start + first;
        int right = end + first;

        int mul = 1;
        while (left <= right) {
            if (left % 2 == 1) {
                mul *= tree[left++];
            }
            if (right % 2 == 0) {
                mul *= tree[right--];
            }
            if (mul == 0) {
                break;
            }
            left /= 2;
            right /= 2;
        }
        return ret[mul + 1];
    }

    private static void update(int index, int value) {
        int i = index + first;
        tree[i] = value;
        while (i > 1) {
            i /= 2;
            tree[i] = tree[i * 2] * tree[i * 2 + 1];
        }
    }

    private static boolean input() throws IOException {
        String line = br.readLine();
        if (line == null || line.equals(""))
            return false;
        st = new StringTokenizer(line);
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        level = (int) Math.ceil(Math.log(N) / Math.log(2));
        first = 1 << (level);
        tree = new int[1 << (level + 1)];
        Arrays.fill(tree, 1);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[first + i] = makeSimple(Integer.valueOf(st.nextToken()));
        }
        return true;
    }

    private static int makeSimple(int value) {
        return value > 0 ? 1 : value < 0 ? -1 : 0;
    }

    private static int init(int node) {
        if (node >= first) {
            return tree[node];
        }
        tree[node * 2] = init(node * 2);
        tree[node * 2 + 1] = init(node * 2 + 1);
        return tree[node * 2] * tree[node * 2 + 1];
    }
}
