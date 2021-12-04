package programmers;

import java.util.Arrays;

public class prob70129 {
    static int countZero;

    public static int[] solution(String s) {
        countZero = 0;
        int trial = 0;
        while (s.length() > 1) {
            trial++;
            int length = removeZeroes(s);
            s = getBiniary(length);

        }
        return new int[] { trial, countZero };
    }

    private static String getBiniary(int length) {
        return Integer.toBinaryString(length);
    }

    private static int removeZeroes(String s) {
        int length = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                length--;
                countZero++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String[] testCases = { "110010101001", "01110", "1111111" };
        for (String string : testCases) {
            System.out.println(Arrays.toString(solution(string)));
        }
    }
}

// "110010101001" [3,8]
// "01110" [3,3]
// "1111111" [4,1]