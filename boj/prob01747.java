package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class prob01747 {
    static final int MAX_SIZE = 1100000;
    static boolean[] isPrime = new boolean[MAX_SIZE];
    static ArrayList<String> primes = new ArrayList<>();
    static int n;

    static void getPrimes() {
        Arrays.fill(isPrime, Boolean.TRUE);
        for (int i = 0; i < 2; i++) {
            isPrime[i] = false;
        }
        int j = 2;
        for (int i = 0; i < MAX_SIZE; i++) {
            if (isPrime[i]) {
                if (i >= n)
                    primes.add(String.valueOf(i));
                j = 2;
                while (i * j < MAX_SIZE)
                    isPrime[i * j++] = false;
            }
        }
    }

    static boolean isPalindrome(String number) {
        int length = number.length();
        int mid = length / 2;
        for (int i = 0; i < mid; i++) {
            if (number.charAt(i) != number.charAt(length - i - 1))
                return false;
        }
        System.out.println(number);
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        getPrimes();
        Iterator<String> it = primes.iterator();
        while (it.hasNext()) {
            if (isPalindrome(it.next()))
                return;
        }
    }
}
