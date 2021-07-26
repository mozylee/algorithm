package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob15655 {
    static int n;
    static int[] nums;
    static String result;
    static String partial;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);
        nm(-1, m, "");
        System.out.println(sb);
    }

    static void nm(int start, int m, String partial) {
        if (m == 1) {
            for (int i = start + 1; i < n; i++)
                sb.append(partial + nums[i] + "\n");
            return;
        }
        for (int i = start + 1; i < n; i++)
            nm(i, m - 1, partial + nums[i] + " ");
    }
}
