// 출처: https://www.acmicpc.net/problem/2588
// 문제: 곱셈


package boj;

import java.util.Scanner;

public class prob02588 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int operand = Integer.parseInt(s.nextLine());
        char[] operand2 = s.nextLine().toCharArray();
        s.close();

        for (int i = 1; i <= operand2.length; i++) {
            System.out.println(operand * (operand2[operand2.length - i] - '0'));
        }
        System.out.println(operand * Integer.parseInt(new String(operand2)));
    }
}
