package boj;

import java.io.*;

public class prob03053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.parseDouble(br.readLine());
        System.out.println(n * n * Math.PI);
        System.out.println(n * n * 2);
    }
}
