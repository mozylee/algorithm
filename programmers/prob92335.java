package programmers;

import java.util.HashSet;

// AC
public class prob92335 {
    private static final int MAX = 1_000_000;

    public static void main(String[] args) {
        int[] n = { 437674, 110011 };
        int[] k = { 3, 10 };
        for (int i = 0; i < 2; i++) {
            System.out.println(solution(n[i], k[i]));
        }
    }

    public static int solution(int n, int k) {
        int answer = 0;
        HashSet<Long> primes = getPrimes();
        String[] st = getConversion(n, k).split("0{1,}");
        for (String s : st) {
            long number = Long.parseLong(s);
            if (primes.contains(number)) {
                answer++;
            } else if (number > MAX && isPrime(number)) {
                primes.add(number);
                answer++;
            }
        }
        return answer;
    }

    static String getConversion(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    static HashSet<Long> getPrimes() {

        HashSet<Long> primes = new HashSet<>();
        boolean[] era = new boolean[MAX + 1];
        for (int i = 0; i < 2; i++) {
            era[i] = true;
        }
        for (int i = 2; i < era.length; i++) {
            if (!era[i]) {
                primes.add((long) i);
                int j = 2;
                while (i * j <= MAX) {
                    era[i * j++] = true;
                }
            }
        }
        return primes;
    }

    static boolean isPrime(long n) {
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= (long) Math.sqrt(n) + 1; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
