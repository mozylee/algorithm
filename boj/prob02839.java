package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob02839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int fiveKilos = N / 5;
        N -= 5 * fiveKilos;
        while (fiveKilos >= 0) {
            if (N % 3 == 0) {
                System.out.println(fiveKilos + N / 3);
                return;
            }
            N += 5;
            fiveKilos--;
        }
        System.out.println(-1);
    }
}
