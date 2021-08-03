package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class prob10867 {
    static TreeSet<Integer> ts = new TreeSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            ts.add(Integer.parseInt(st.nextToken()));
        for (int n : ts)
            sb.append(n).append(" ");
        System.out.println(sb);
    }
}
