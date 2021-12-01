package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob11256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int J = Integer.valueOf(st.nextToken());
            int N = Integer.valueOf(st.nextToken());
            
            int[] boxes = getBoxes(br, N);
            Arrays.sort(boxes);

            sb.append(countBox(J, N, boxes)).append("\n");
        }
        System.out.println(sb);
    }

    private static int countBox(int J, int N, int[] boxes) {
        int count = 0;
        for (int k = N - 1; k >= 0; k--) {
            J -= boxes[k];
            count++;
            if (J <= 0)
                break;
        }
        return count;
    }

    private static int[] getBoxes(BufferedReader br, int N) throws IOException {
        StringTokenizer st;
        int[] boxes = new int[N];
        for (int k = 0; k < N; k++) {
            st = new StringTokenizer(br.readLine());
            boxes[k] = Integer.valueOf(st.nextToken()) * Integer.valueOf(st.nextToken());
        }
        return boxes;
    }
}