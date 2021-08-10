package boj;

import java.io.*;
import java.util.*;

public class prob01316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[26];  // HashSet으로도 가능
        int count = n;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            Arrays.fill(check, Boolean.FALSE);
            check[input.charAt(0) - 'a'] = true;
            for (int j = 1; j < input.length(); j++) {
                if (input.charAt(j) != input.charAt(j - 1) && check[input.charAt(j) - 'a']) {
                    count--;
                    break;
                }
                check[input.charAt(j)] = true;
            }
        }
        System.out.println(count);
    }
}
