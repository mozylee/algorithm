package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class prob14607 {

    public static void main(String[] args) {
        long n = getNumber();

        long result = calculate(n);

        System.out.println(result);
    }

    private static long calculate(long n) {
        if (n <= 1) {
            return 0;
        }

        long half = n / 2;
        long another = n - half;

        return calculate(half) + calculate(another) + half * another;
    }

    private static long getNumber() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return Long.parseLong(br.readLine());
        } catch (Exception e) {
            System.out.println("ERROR!!!");
        }

        return 0;
    }


}
