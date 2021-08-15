package boj;

import java.io.*;
import java.util.StringTokenizer;

public class prob01002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            double r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            double r2 = Integer.parseInt(st.nextToken());
            int r = (int) Math.pow(x1 - x2, 2) + (int) Math.pow(y1 - y2, 2);
            int sum = (int) Math.pow(r1 + r2, 2);
            int diff = (int) Math.pow(r1 - r2, 2);
            int result = 2;
            if (diff == 0 && x1 == x2 && y1 == y2) {
                result = -1;
            } else if (sum < r || diff > r) {
                result = 0;
            } else if (r == diff || r == sum) {
                result = 1;
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}