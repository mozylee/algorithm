package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] value = new int[n + 2];
        int[] time = new int[n + 1];
        int[] dp = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int temp = Integer.parseInt(st.nextToken());
            value[i] = (time[i] > n - i + 1) ? 0 : temp;
            dp[i] = value[i];
        }

        for (int i = n; i >= 1; i--) {
            dp[i] = (time[i] > n - i + 1) ? dp[i + 1] : Math.max(dp[i + 1], dp[i + time[i]] + value[i]);
        }
        System.out.println(dp[1]);
    }
}
