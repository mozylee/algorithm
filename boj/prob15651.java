package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob15651 {
    static int n;
    static String result;
    static String partial;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        nm(m, "");
        System.out.println(sb);
    }

    static void nm(int m, String partial) {
        if (m == 1) {
            for (int i = 1; i <= n; i++)
                sb.append(partial + i + "\n");
            return;
        }
        for (int i = 1; i <= n; i++)
            nm(m - 1, partial + i + " ");
    }
}
