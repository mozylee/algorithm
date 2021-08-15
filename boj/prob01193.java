package boj;

import java.io.*;

public class prob01193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(getFractional(n));
    }

    static String getFractional(int n) {
        int count = 0;
        boolean isLeft = true;
        for (int check = 2; check < 10000; check++) {
            int numerator = isLeft ? check - 1 : 1;
            int denominator = check - numerator;
            while (numerator >= 1 && numerator < check) {
                if (++count == n) {
                    return numerator + "/" + denominator;
                }
                numerator += isLeft ? -1 : 1;
                denominator += isLeft ? 1 : -1;
            }
            isLeft = !isLeft;
        }
        return "ERROR";
    }
}
