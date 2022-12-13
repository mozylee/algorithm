package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob01275 {
    private static long[] tree;
    private static int level, first;
    private static int N, Q;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] parameters = new int[4];

    private static final int X = 0, Y = 1, A = 2, B = 3;

    public static void main(String[] args) throws IOException {
        input();

        tree[1] = init(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            setParameters();

            sb.append(sum(parameters[X], parameters[Y])).append("\n");
            update(parameters[A], parameters[B]);
        }
        
        System.out.println(sb);
    }

    private static long init(int node) throws NumberFormatException, IOException {
        if (node >= first) {
            return tree[node];
        }

        tree[node * 2] = init(node * 2);
        tree[node * 2 + 1] = init(node * 2 + 1);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
        return tree[node];
    }

    private static void setParameters() throws IOException {
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        parameters[B]++;

        if (parameters[X] <= parameters[Y]) {
            return;
        }

        swapXY();
    }

    private static void swapXY() {
        int temp = parameters[X];
        parameters[X] = parameters[Y];
        parameters[Y] = temp;
    }

    private static long sum(int start, int end) {
        int left = start + first;
        int right = end + first;

        long sum = 0;
        while (left <= right) {
            if (left % 2 == 1) {
                sum += tree[left++];
            }

            if (right % 2 == 0) {
                sum += tree[right--];
            }

            left /= 2;
            right /= 2;
        }

        return sum;
    }

    private static void update(int index, long value) {
        int i = index + first;

        tree[i] = value;
        while (i > 1) {
            i /= 2;
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        Q = Integer.valueOf(st.nextToken());

        level = (int) Math.ceil(Math.log(N) / Math.log(2));
        first = 1 << (level);
        tree = new long[1 << (level + 1)];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[first + i] = Long.valueOf(st.nextToken());
        }
    }
}
