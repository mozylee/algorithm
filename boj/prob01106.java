package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class prob01106 {
    private static int N, C;
    private static List<City> cities;

    private static final int MAX_VALUE = 100_000_000;

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(dp());
    }

    private static int dp() {
        int[] dp = new int[C + 100];
        Arrays.fill(dp, MAX_VALUE);
        dp[0] = 0;

        for (City c : cities) {
            for (int i = c.count; i < dp.length; i++) {
                dp[i] = Math.min(dp[i], dp[i - c.count] + c.cost);
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = C; i < dp.length; i++) {
            minCost = Math.min(minCost, dp[i]);
        }

        return minCost;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        cities = new ArrayList<>(N);
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            cities.add(new City(cost, count));
        }
    }

    private static class City {
        int cost;
        int count;

        City(int cost, int count) {
            this.cost = cost;
            this.count = count;
        }
    }
}
