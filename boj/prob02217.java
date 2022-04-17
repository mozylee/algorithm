package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class prob02217 {
    private static int N;
    private static int[] ropes;

    public static void main(String[] args) throws IOException {
        input();

        int max = ropes[0] * N;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, ropes[i] * (N - i));
        }
        System.out.println(max);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ropes = new int[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);
    }
}
