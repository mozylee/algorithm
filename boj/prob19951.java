package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class prob19951 {
    static int N, M;
    static int[] ground;
    static int[] accmulating;

    public static void main(String[] args) throws IOException {
        input();
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N - 1; i++) {
            accmulating[i + 1] += accmulating[i];
            sb.append(ground[i] + accmulating[i] + " ");
        }
        sb.append(ground[N - 1] + accmulating[N - 1]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        ground = new int[N];
        accmulating = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ground[i] = Integer.valueOf(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            int amount = Integer.valueOf(st.nextToken());
            accmulating[start - 1] += amount;
            if (end == N)
                continue;
            accmulating[end] -= amount;
        }
    }
}

// 10 3
// 1 2 3 4 5 -1 -2 -3 -4 -5
// 1 5 -3
// 6 10 5
// 2 7 2