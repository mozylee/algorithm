package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class prob10211 {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int t = getNumber();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t; i++) {
            result.append(calculateMaximumSubArray(getNumber(), getNumbers()))
                  .append("\n");
        }

        System.out.println(result.toString().trim());
    }

    private static int calculateMaximumSubArray(int number, List<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : numbers) {
            sum = Math.max(sum + i, i);
            max = Math.max(max, sum);
        }

        return max;
    }

    private static int getNumber() throws IOException {
        return Integer.parseInt(READER.readLine());
    }

    private static List<Integer> getNumbers() throws IOException {
        StringTokenizer st = new StringTokenizer(READER.readLine());

        return Stream.iterate(st, StringTokenizer::hasMoreTokens, x -> x)
                     .map(StringTokenizer::nextToken)
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

}
