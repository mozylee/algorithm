package boj;

import java.io.*;
import java.util.StringTokenizer;

public class prob02304 {
    static final int WIDTH = 1000;
    static int[] blocks;

    public static void main(String[] args) {
        input();
        System.out.println(makeRain());
    }

    static int makeRain() {
        int[] leftMax = new int[WIDTH];
        int[] rightMax = new int[WIDTH];
        leftMax[0] = blocks[0];
        rightMax[WIDTH - 1] = blocks[WIDTH - 1];
        for (int i = 1, j = WIDTH - 2; i < WIDTH; i++, j--) {
            leftMax[i] = Math.max(leftMax[i - 1], blocks[i]);
            rightMax[j] = Math.max(rightMax[j + 1], blocks[j]);
        }
        int sum = 0;
        for (int i = 0; i < WIDTH; i++) {
            sum += Math.min(leftMax[i], rightMax[i]);
        }
        return sum;
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int N = Integer.parseInt(br.readLine());
            blocks = new int[WIDTH];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int L = Integer.parseInt(st.nextToken()) - 1;
                int H = Integer.parseInt(st.nextToken());
                blocks[L] = H;
            }
        } catch (Exception e) {
            System.out.println("ERROR!!!");
        }
    }
}
