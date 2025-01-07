package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class prob01965 {

    public static void main(String[] args) throws IOException {
        int[] arr = getArr();

        int result = calculate(arr);

        System.out.println(result);
    }

    private static int calculate(int[] arr) {
        int length = arr.length;

        Integer[] lis = new Integer[length];
        Arrays.fill(lis, Integer.MAX_VALUE);
        lis[0] = arr[0];
        int right = 0;

        for (int i : arr) {
            if (lis[right] < i) {
                lis[++right] = i;
                continue;
            }

            int index = getIndexWithBinarySearch(0, right, i, lis, Integer::compare);
            lis[index] = i;
        }

        return right + 1;
    }


    private static int[] getArr() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        reader.readLine();
        StringTokenizer st = new StringTokenizer(reader.readLine());

        return Stream.iterate(st, StringTokenizer::hasMoreTokens, x -> x)
                     .map(StringTokenizer::nextToken)
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }

    private static <T> int getIndexWithBinarySearch(int left, int right, T target, T[] arr, Comparator<T> comparator) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (comparator.compare(arr[mid], target) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

}
