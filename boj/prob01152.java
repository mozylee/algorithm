package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob01152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().strip();
        if(input.equals("")){
            System.out.println(0);
            return;
        }
        System.out.println(input.length() - input.replace(" ", "").length() + 1);
    }
}
