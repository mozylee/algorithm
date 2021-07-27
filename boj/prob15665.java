package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class prob15665 {
    static int n;
    static TreeSet<Integer> nums = new TreeSet<Integer>();
    static String result;
    static String partial;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            nums.add(Integer.parseInt(st.nextToken()));
        nm(m, "");
        System.out.println(sb);
    }

    static void nm(int m, String partial) {
        Iterator<Integer> it = nums.iterator();
        if (m == 1) {
            while (it.hasNext())
                sb.append(partial + it.next() + "\n");
            return;
        }
        while (it.hasNext())
            nm(m - 1, partial + it.next() + " ");
    }
}
