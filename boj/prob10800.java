package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


// UNSOLVED!!!!!!!!!!!!!!
public class prob10800 {
    private static int N;

    private static ArrayList<ColorBall> balls = new ArrayList<>();

    private static int[] sumSize;

    public static void main(String[] args) throws IOException {
        input();

        getSumSize();

        System.out.print(getResultString());
    }

    private static void getSumSize() {
        int beforeSize = 0;
        int beforeSum = 0;
        int nowSum = 0;
        int[] sumSizeByColor = new int[N];
    }

    private static StringBuilder getResultString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(sumSize[i]).append("\n");
        }
        return sb;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            balls.add(new ColorBall(size, color, i));
        }

        balls.sort(null);
    }

    private static final class ColorBall implements Comparable<ColorBall> {
        int size;
        int color;
        int index;

        ColorBall(int size, int color, int index) {
            this.size = size;
            this.color = color;
            this.index = index;
        }

        @Override
        public int compareTo(ColorBall c) {
            return this.size == c.size ? this.color - c.color : this.size - c.size;
        }
    }
}
