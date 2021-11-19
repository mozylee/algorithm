package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob09024 {
    private static int N, K;
    private static int[] nums;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.valueOf(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int k = 0; k < T; k++) {
            input();
            Arrays.sort(nums);

            int min = Integer.MAX_VALUE;
            int count = 0;
            int left = 0, right = N - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (Math.abs(K - sum) < min) {
                    count = 0;
                    min = Math.abs(K - sum);
                }
                count += Math.abs(K - sum) == min ? 1 : 0;
                
                if (sum < K) {
                    left++;
                } else if (sum > K) {
                    right--;
                } else {
                    left++;
                    right--;
                }
            }
            ans.append(count).append("\n");
        }
        System.out.println(ans);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
        }
    }
}
