package programmers;

import java.util.Arrays;

public class prob12913 {
    static int solution(int[][] land) {
        int[][] conqueredLand = copyArray(land);
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                conqueredLand[i][j] += getMax(conqueredLand[i - 1], j);
            }
        }
        return getMax(conqueredLand[land.length - 1], 4);
    }

    static int[][] copyArray(int[][] arr) {
        int[][] copy = new int[arr.length][4];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = Arrays.copyOf(arr[i], 4);
        }
        return copy;
    }

    static int getMax(int[] a, int index) {
        int max = 0;
        for (int i = 0; i < 4; i++) {
            if (i == index)
                continue;
            max = Math.max(max, a[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
        // 16
        System.out.println(solution(land));
    }
}