package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob01110 {

    public static void main(String[] args) throws IOException {
        int origin = input();
        int n = origin;
        int count = 0;

        while (true) {
            n = cycle(n);
            count++;
            if (n == origin)
                break;
        }
        System.out.println(count);
    }

    public static int cycle(int n) {
        int second = n % 10;
        int sum = (n / 10 + second) % 10;
        return second * 10 + sum;
    }

    public static int input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            return n;
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
        return 0;
    }
}
