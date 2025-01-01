package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob15489 {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        Values values = getValues();

        long[][] matrix = getMatrix(values);
        // for (long[] longs : matrix) {
        //     System.out.println(Arrays.toString(longs));
        // }

        long result = calculate(matrix, values.r, values.c, values.w);

        System.out.println(result);
    }

    private static long calculate(long[][] matrix, int r, int c, int w) {
        long result = 0L;

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < i+1; j++) {
                // System.out.println((r + i) + ", " + (c + j));
                result += matrix[r + i - 1][c + j - 1];
            }
        }

        return result;
    }

    private static long[][] getMatrix(Values values) {
        long[][] matrix = new long[values.r + values.w + 2][values.c + values.w + 2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j > i) {
                    break;
                }
                if (i == 0 || j == 0) {
                    matrix[i][j] = 1;
                    continue;
                }

                matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
            }
        }

        return matrix;
    }

    private static Values getValues() throws IOException {
        StringTokenizer st = new StringTokenizer(READER.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        return new Values(r, c, w);
    }

    private static final class Values {

        int r;

        int c;

        int w;

        public Values(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

    }

}
