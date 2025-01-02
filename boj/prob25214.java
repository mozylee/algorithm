package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class prob25214 {


    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        readInt();
        List<Integer> values = getValues();

        String result = calculate(values);

        System.out.println(result);
    }

    private static String calculate(List<Integer> values) {
        StringBuilder sb = new StringBuilder();

        int min = Integer.MAX_VALUE; // i까지의 최소값
        int max = Integer.MIN_VALUE; // min의 index보다 큰 위치에서의 최대값
        int maxSum = Integer.MIN_VALUE;

        for (Integer value : values) {
            max = min > value ? value : Math.max(max, value);
            min = Math.min(min, value);
            maxSum = Math.max(max - min, maxSum);

            // System.out.println("value = " + value);
            // System.out.println("min = " + min);
            // System.out.println("max = " + max);
            // System.out.println("result = " + maxSum);
            // System.out.println("----------------------------------------");
            sb.append(maxSum).append(" ");
        }

        return String.valueOf(sb);
    }

    private static List<Integer> getValues() throws IOException {
        StringTokenizer st = new StringTokenizer(READER.readLine());

        return Stream.iterate(st, StringTokenizer::hasMoreTokens, x -> x)
                     .map(StringTokenizer::nextToken)
                     .mapToInt(Integer::parseInt)
                     .boxed()
                     .collect(Collectors.toList());
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(READER.readLine());
    }

}