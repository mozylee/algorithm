package boj;

import java.io.*;
import java.util.StringTokenizer;

public class prob10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String number1 = st.nextToken();
        String number2 = st.nextToken();
        StringBuilder result = new StringBuilder();

        boolean isCarry = false;
        for (int i = number1.length() - 1, j = number2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = isCarry ? 1 : 0;
            if (i >= 0)
                sum += number1.charAt(i) - '0';
            if (j >= 0)
                sum += number2.charAt(j) - '0';
            if (sum >= 10) {
                isCarry = true;
                sum %= 10;
            } else {
                isCarry = false;
            }
            result.append(sum);
        }
        if (isCarry)
            result.append(1);
        System.out.println(result.reverse());
    }
}
