package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// S3: DP
public class prob04097 {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(READER.readLine());
            if (n <= 0) {
                break;
            }

            List<Integer> profits = IntStream.range(0, n)
                                             .map(i -> {
                                                 try {
                                                     return Integer.parseInt(READER.readLine());
                                                 } catch (IOException e) {
                                                     throw new RuntimeException(e);
                                                 }
                                             })
                                             .boxed()
                                             .collect(Collectors.toList());

            sb.append(calculate(profits)).append("\n");
        }

        System.out.println(sb);
    }

    private static int calculate(List<Integer> profits) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int profit : profits) {
            sum = Math.max(sum, 0) + profit;
            max = Math.max(max, sum);
        }

        return max;
    }

}
