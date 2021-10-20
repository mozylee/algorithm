package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class prob01717 {
    private static int[] parents;
    private static final String EMPTY = "", YES = "YES\n", NO = "NO\n";
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.valueOf(st.nextToken());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            String res = EMPTY;
            switch (op) {
                case 0:
                    union(a, b);
                    break;
                case 1:
                    res = getParent(a) == getParent(b) ? YES : NO;
                    break;
            }
            sb.append(!res.equals(EMPTY) ? res : EMPTY);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void union(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int pMin = getParent(min);
        int pMax = getParent(max);
        if (pMin != pMax) {
            parents[pMax] = pMin;
        }
    }

    private static int getParent(int a) {
        if (a == parents[a]) {
            return a;
        }
        parents[a] = getParent(parents[a]);
        return parents[a];
    }
}
