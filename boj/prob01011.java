package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob01011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int k = -(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));
            double sqrt = Math.sqrt(k);
            int roundedSqrt = (int) Math.round(sqrt);
            if (sqrt <= roundedSqrt) {
                sb.append(2 * roundedSqrt - 1).append('\n');
            } else {
                sb.append(2 * roundedSqrt).append('\n');
            }
        }
        System.out.println(sb);
    }
}
