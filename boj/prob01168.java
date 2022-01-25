package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob01168 {
    private static int N, K;
    private static int level, first;
    private static int[] tree;

    public static void main(String[] args) throws IOException {
        input();

        setTreeValues();
        init(1);

        StringBuilder sb = new StringBuilder();
        int rank = 0;
        for (int i = 0; i < N - 1; i++) {
            rank = (rank + K - 1) % (N - i);
            sb.append(pop((rank + 1), 1)).append(", ");
        }
        sb.append(pop(1, 1));
        System.out.println("<" + sb + ">");
    }

    private static void setTreeValues() {
        level = (int) Math.ceil(Math.log(N) / Math.log(2));
        first = 1 << level;
        tree = new int[2 << level];

        for (int i = 0; i < N; i++) {
            tree[i + first]++;
        }
    }

    private static int init(int node) {
        if (node >= first) {
            return tree[node];
        }
        tree[node] = init(node * 2) + init(node * 2 + 1);
        return tree[node];
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    private static int pop(int rank, int index) {
        if (index >= first) {
            int out = index - first;
            update(out, -1);
            return out + 1;
        }
        return rank <= tree[index * 2] ? pop(rank, index * 2) : pop(rank - tree[index * 2], index * 2 + 1);
    }

    private static void update(int index, int value) {
        int i = index + first;
        tree[i] += value;
        while (i > 1) {
            i /= 2;
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }
}