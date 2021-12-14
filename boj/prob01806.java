package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob01806 {
    private static int N, S;
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        input();

        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        int sum = nums[0];
        while (left <= N - 1) {
            if (sum >= S) {
                min = Math.min(min, (right - left + 1));
                sum -= nums[left++];
            } else {
                if (right < N - 1) {
                    sum += nums[++right];
                } else {
                    break;
                }
            }
        }
        System.out.println(min < Integer.MAX_VALUE ? min : 0);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        S = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
        }
    }
}
