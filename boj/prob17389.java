package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob17389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        String answers = br.readLine();
        int result = 0;
        int bonus = 0;
        for (int i = 0; i < answers.length(); i++) {
            if (answers.charAt(i) == 'X') {
                bonus = 0;
                continue;
            }
            result += (i + 1) + bonus++;
        }
        System.out.println(result);
    }
}
