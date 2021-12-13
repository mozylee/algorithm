package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob02243 {
    private static final int LEVEL = 20;
    private static int first = 1 << LEVEL;
    private static int[] tree = new int[2 << LEVEL];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.valueOf(br.readLine());
        for (int k = 0; k < n; k++) {
            st = new StringTokenizer(br.readLine());
            boolean op = st.nextToken().equals("1");
            if (op) {
                int rank = Integer.valueOf(st.nextToken());
                sb.append(pop(rank, 1)).append("\n");
            } else {
                int taste = Integer.valueOf(st.nextToken());
                int count = Integer.valueOf(st.nextToken());
                update(taste, count);
            }
        }
        System.out.println(sb);
    }

    private static int pop(int rank, int index) {
        if (index >= first) {
            int taste = index - first;
            update(taste, -1);
            return taste;
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
