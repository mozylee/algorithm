package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class prob02870 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        ArrayList<BigInteger> numbers = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            for (String num : br.readLine().split("[a-zA-z]+")) {
                if (num.equals(""))
                    continue;
                numbers.add(new BigInteger(num));
            }
        }

        numbers.sort(null);
        StringBuilder sb = new StringBuilder();
        for (BigInteger num : numbers) {
            sb.append(num).append("\n");
        }
        System.out.print(sb);
    }
}
