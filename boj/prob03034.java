package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob03034 {

    private static int N, W, H;
    private static int[] matches;

    public static void main(String[] args) throws IOException {
        input();
        double maxLength = Math.sqrt(Math.pow(W, 2) + Math.pow(H, 2));

        StringBuilder sb = new StringBuilder();
        for (int match : matches) {
            sb.append(match <= maxLength ? "DA" : "NE").append("\n");
        }

        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        matches = new int[N];
        for (int i = 0; i < matches.length; i++) {
            matches[i] = Integer.parseInt(br.readLine());
        }
    }
}
