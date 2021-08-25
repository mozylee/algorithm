package boj;

import java.io.*;
import java.util.StringTokenizer;

public class prob02845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int attendees = L * P;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            sb.append(Integer.parseInt(st.nextToken()) - attendees).append(' ');
        }
        System.out.println(sb);
    }
}
