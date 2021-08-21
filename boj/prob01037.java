package boj;

import java.io.*;
import java.util.StringTokenizer;

public class prob01037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < amount; i++) {
            int divisor = Integer.parseInt(st.nextToken());
            min = Math.min(min, divisor);
            max = Math.max(max, divisor);
        }
        System.out.println(min * max);
    }
}
