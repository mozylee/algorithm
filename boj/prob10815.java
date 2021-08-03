package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class prob10815 {
    static HashSet<Integer> hs = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            hs.add(Integer.parseInt(st.nextToken()));
        br.readLine();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            sb.append(hs.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append(' ');
        System.out.println(sb);
    }
}
