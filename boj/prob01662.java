package boj;

import java.io.*;
import java.util.Stack;

public class prob01662 {
    public static void main(String[] args) {
        String str = input();
        Stack<Element> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - '0';
            if (c != -7) {
                c = c < 0 ? -1 : c;
                stack.add(new Element(c, false));
                continue;
            }
            int length = 0;
            while (!stack.isEmpty() && stack.peek().value() >= 0) {
                length += stack.pop().value();
            }
            stack.pop();
            stack.add(new Element(stack.pop().value * length, true));
        }
        int total = 0;
        for (Element e : stack) {
            total += e.value();
        }
        System.out.println(total);
    }

    static String input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine().strip();
        } catch (Exception e) {
            System.out.println("ERROR!!!");
            return "";
        }
    }

    static class Element {
        int value;
        boolean isSum;

        Element(int value, boolean isSum) {
            this.value = value;
            this.isSum = isSum;
        }

        int value() {
            if (!isSum) {
                return value > 0 ? 1 : -1;
            }
            return value;
        }

        @Override
        public String toString() {
            return value + "(" + isSum + ")";
        }
    }
}
