package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class prob01644 {
    private static int[] primes = new int[400000 + 1];
    private static int N, count;
    private static boolean[] eratosthenes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        getPrimes();

        int start = 0, end = 0, sum = primes[0];
        int result = 0;
        while (end < count)
            if (sum >= N) {
                if (sum == N)
                    result++;
                sum -= primes[start++];
            } else
                sum += primes[++end];

        System.out.println(result);
    }

    private static void getPrimes() {
        eratosthenes = new boolean[N + 1];
        Arrays.fill(eratosthenes, Boolean.TRUE);
        for (int i = 0; i < 2; i++) {
            eratosthenes[i] = false;
        }
        int length = eratosthenes.length;
        int j = 2;
        for (int i = 2; i < length; i++) {
            if (eratosthenes[i]) {
                primes[count++] = i;
                j = 2;
                while (i * j <= N)
                    eratosthenes[i * j++] = false;
            }
        }
    }
}
