package boj;

import java.io.*;

public class prob14606 {

    public static void main(String[] args) {
        int n = getNumber();

        int result = calculate(n);

        System.out.println(result);
    }

    private static int calculate(int n) {
        if (n <= 1) {
            return 0;
        }

        int half = n / 2;
        int another = n - half;

        return calculate(half) + calculate(another) + half * another;
    }

    private static int getNumber() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.out.println("ERROR!!!");
        }

        return 0;
    }

}
