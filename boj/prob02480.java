// 출처: https://www.acmicpc.net/problem/2480
// 문제: 주사위 세개


package boj;

import java.util.Arrays;
import java.util.Scanner;

public class prob02480 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] dices = new int[3];
        for (int i = 0; i < dices.length; i++) {
            dices[i] = s.nextInt();
        }
        s.close();
        Arrays.sort(dices);
        
        int res = 0;
        if (dices[0] == dices[2]) {
            res = 10000 + 1000 * dices[1];
        } else if (dices[0] == dices[1] || dices[1] == dices[2]) {
            res = 1000 + 100 * dices[1];
        } else {
            res = dices[2] * 100;
        }
        System.out.println(res);
    }
}
