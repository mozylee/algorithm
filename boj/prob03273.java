package boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob03273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        System.out.println(solution2(n, nums, x));
    }

    static int solution2(int n, int[] nums, int x) {
        Arrays.sort(nums);
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < x) {
                i++;
            } else if (sum > x) {
                j--;
            } else {
                count++;
                i++;
            }
        }
        return count;
    }
}
