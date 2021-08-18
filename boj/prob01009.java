package boj;

import java.io.*;
import java.util.StringTokenizer;

public class prob01009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = power(a, b);
            sb.append(result > 0 ? result : 10).append('\n');
        }
        System.out.println(sb);
    }

    static int power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        int half = power(a, b / 2) % 10;
        int result = half * half;
        if (b % 2 == 1) {
            result *= a;
        }
        return result % 10;
    }
}
