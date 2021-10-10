package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob10798 {
    private static final int SIZE = 5;
    private static final int MAX_STR_SIZE = 15;

    public static void main(String[] args) throws IOException {
        String[] words = input();
        for (int j = 0; j < MAX_STR_SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                System.out.print(j < words[i].length() ? ((char) words[i].charAt(j) + "") : "");
            }
        }
    }

    private static String[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ret = new String[SIZE];
        for (int i = 0; i < SIZE; i++)
            ret[i] = br.readLine();
        return ret;
    }
}
