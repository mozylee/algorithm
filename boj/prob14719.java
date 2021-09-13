package boj;

import java.io.*;
import java.util.StringTokenizer;

public class prob14719 {
    static int H, W;
    static int[] blocks;

    public static void main(String[] args) {
        input();
        System.out.println(makeRain());
    }

    static int makeRain() {
        int[] leftMax = new int[W];
        int[] rightMax = new int[W];
        leftMax[0] = blocks[0];
        rightMax[W - 1] = blocks[W - 1];
        for (int i = 1, j = W - 2; i < W; i++, j--) {
            leftMax[i] = Math.max(leftMax[i - 1], blocks[i]);
            rightMax[j] = Math.max(rightMax[j + 1], blocks[j]);
        }
        int sum = 0;
        for (int i = 0; i < W; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - blocks[i];
        }
        return sum;
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            blocks = new int[W];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < W; i++) {
                blocks[i] = Integer.parseInt(st.nextToken());
            }
        } catch (Exception e) {
            System.out.println("ERROR!!!");
        }
    }
}
