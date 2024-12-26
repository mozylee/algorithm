package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class prob2670 {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = readInt();

        BigDecimal result = calculate(n);

        System.out.println(result.setScale(3, RoundingMode.HALF_UP));
    }

    private static BigDecimal calculate(int n) throws IOException {
        BigDecimal max = BigDecimal.valueOf(Double.MIN_VALUE);
        BigDecimal sub = BigDecimal.ONE;

        for (int i = 0; i < n; i++) {
            BigDecimal value = readBigDecimal();

            sub = value.max(sub.multiply(value));
            max = max.max(sub);
        }

        return max;
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(READER.readLine());
    }

    private static BigDecimal readBigDecimal() throws IOException {
        return new BigDecimal(READER.readLine());
    }

}
