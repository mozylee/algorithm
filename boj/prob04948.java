package boj;

import java.io.*;

public class prob04948 {
    static final int MAX_VALUE = 2 * 123456;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] eratosthenes = getEratosthenes();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (i <= MAX_VALUE && !eratosthenes[i]) {
                    count++;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    static boolean[] getEratosthenes() {
        boolean[] eratosthenes = new boolean[MAX_VALUE + 1];
        eratosthenes[1] = true;
        for (int i = 2; i <= MAX_VALUE; i++) {
            if (!eratosthenes[i]) {
                int j = 1;
                while (i * ++j <= MAX_VALUE) {
                    eratosthenes[i * j] = true;
                }
            }
        }
        return eratosthenes;
    }
}
