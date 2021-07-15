package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class prob02475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int ret = 0;

        for (int i = 0; i < str.length; i++) {
            int num = Integer.parseInt(str[i]);
            ret += num * num;
        }   

        System.out.println(ret % 10);
    }
}
