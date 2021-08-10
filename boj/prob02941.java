package boj;

import java.io.*;

public class prob02941 {
    static final String[] CROATIAN = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (int i = 0; i < 8; i++)
            input = input.replaceAll(CROATIAN[i], "T");
        System.out.println(input);
        System.out.println(input.length());
    }
}
