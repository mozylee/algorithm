package boj;

import java.io.*;
import java.util.*;

public class prob10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean isLasor = false;
        Stack<Character> stack = new Stack<>();
        int total = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.add('(');
                isLasor = true;
                continue;
            }
            stack.pop();
            total += isLasor ? stack.size() : 1;
            isLasor = false;
        }
        System.out.println(total);
    }

    public static void mainWithoutStack(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean isLasor = false;
        int total = 0;
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                count++;
                isLasor = true;
                continue;
            }
            count--;
            total += isLasor ? count : 1;
            isLasor = false;
        }
        System.out.println(total);
    }
}
