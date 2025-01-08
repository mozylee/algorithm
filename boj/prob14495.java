package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class prob14495 {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = readInt();

        BigInteger result = calculate(n);

        System.out.println(result);
    }

    private static BigInteger calculate(int n) throws IOException {
        if (n <= 3) {
            return BigInteger.ONE;
        }

        List<BigInteger> dp = new ArrayList<>(List.of(BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE));
        for (int i = 4; i <= n; i++) {
            dp.add(dp.get(i - 1).add(dp.get(i - 3)));
        }

        return dp.get(n);
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(READER.readLine());
    }

}
