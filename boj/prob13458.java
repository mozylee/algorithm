package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob13458 {
    static int N, B, C;
    static long sum;
    static int candidates;
    static int[] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        room = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            room[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        sum = N;
        for (int i = 0; i < N; i++) {
            candidates = room[i] - B;
            if (candidates > 0) {
                sum += candidates / C;
                sum += candidates % C != 0 ? 1 : 0;
            }
        }
        System.out.println(sum);
    }
}
