// 출처: https://www.acmicpc.net/problem/1085
// 문제: 직사각형에서 탈출


package boj;

import java.util.Scanner;
import java.lang.Math;

public class prob01085 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        int w = s.nextInt();
        int h = s.nextInt();
        s.close();
        int minX = Math.min(x, w - x);
        int minY = Math.min(y, h - y);
        System.out.println(Math.min(minX, minY));
    }
}
