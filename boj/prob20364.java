package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob20364 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int Q = Integer.valueOf(st.nextToken());
        boolean[] tree = new boolean[N + 1];
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < Q; k++) {
            int X = Integer.valueOf(br.readLine());
            int i = X;
            int ans = 0;
            while (i > 1) {
                ans = tree[i] ? i : ans;
                i >>= 1;
            }
            tree[X] = true;
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
