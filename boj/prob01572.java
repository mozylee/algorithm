package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob01572 {
    private static final int LEVEL = 17; // log2(65536)<=17
    private static int first = 1 << (LEVEL);
    private static int[] temparatures;
    private static int[] tree = new int[1 << (LEVEL + 1)];
    private static int N, K;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        input();
        init(1);

        int rank = (K + 1) / 2;
        long sum = 0;
        int i;
        for (i = 0; i < K - 1; i++) {
            update(temparatures[i], 1);
        }
        for (; i < N; i++) {
            update(temparatures[i], 1);
            sum += getMid(rank, 1);
            update(temparatures[i - K + 1], -1);
        }
        System.out.println(sum);
    }

    private static void update(int index, int value) {
        int i = index + first;
        tree[i] += value;
        while (i > 1) {
            i /= 2;
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    private static int getMid(int rank, int index) {
        if (index >= first) {
            return index - first;
        }
        return rank <= tree[index * 2] ? getMid(rank, index * 2) : getMid(rank - tree[index * 2], index * 2 + 1);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());
        temparatures = new int[N];

        for (int i = 0; i < N; i++) {
            temparatures[i] = Integer.parseInt(br.readLine());
        }
    }

    private static int init(int node) {
        if (node >= first) {
            return tree[node];
        }
        tree[node] = init(node * 2) + init(node * 2 + 1);
        return tree[node];
    }
}
