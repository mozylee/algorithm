package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob15656 {
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
        nm(m, "");
        System.out.println(sb);
    }

    static void nm(int m, String partial) {
        if (m == 0) {
            sb.append(partial + "\n");
            return;
        }
        for (int i = 0; i < n; i++)
            nm(m - 1, partial + nums[i] + " ");

    }
}
