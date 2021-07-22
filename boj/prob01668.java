package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob01668 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] trophies = new int[n];
        for (int i = 0; i < trophies.length; i++) {
            trophies[i] = Integer.parseInt(br.readLine());
        }
        int forward = 1;
        int f = trophies[0];
        int backward = 1;
        int b = trophies[n - 1];
        for (int i = 1; i < trophies.length; i++) {
            if (f < trophies[i]) {
                forward++;
                f = trophies[i];
            }
            if (b < trophies[n - i - 1]) {
                backward++;
                b = trophies[n - i - 1];
            }
        }
        System.out.println(forward + "\n" + backward);
    }
}
