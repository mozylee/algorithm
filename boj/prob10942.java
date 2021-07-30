package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class prob10942 {
    private static StringBuilder output = new StringBuilder();
    private static int[] nums;
    private static int start, end;

    public static int isPalin(int start, int end) {
        int left = start;
        int right = end;
        while (left <= right)
            if (nums[left++] != nums[right--])
                return 0;
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nums = new int[Integer.parseInt(br.readLine())];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            output.append(isPalin(start - 1, end - 1)).append('\n');
        }
        System.out.println(output);
    }
}
