package boj;

import java.io.*;
import java.util.StringTokenizer;

public class prob03003 {
    static final int[] PIECES = { 1, 1, 2, 2, 2, 8 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < PIECES.length; i++) {
            sb.append(PIECES[i] - Integer.parseInt(st.nextToken())).append(' ');
        }
        System.out.println(sb);
    }
}
