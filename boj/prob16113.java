package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob16113 {
    private static int N;
    private static boolean[][] signal;

    private static final int SIZE = 5;

    private static StringBuilder res = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();

        int i = 0;
        while (i < N) {
            if (!signal[0][i]) {
                i++;
                continue;
            }
            i += checkLine(i) ? 3 : 1;
        }

        System.out.print(res);
    }

    private static boolean checkLine(int i) {
        if (!signal[1][i]) {
            // 2, 3, 7
            if (signal[3][i]) {
                res.append(2);
            } else {
                res.append(signal[2][i] ? 3 : 7);
            }
        } else {
            if (!signal[3][i]) {
                // 4, 5, 9
                if (!signal[0][i + 1]) {
                    res.append(4);
                } else {
                    res.append(signal[1][i + 2] ? 9 : 5);
                }
            } else {
                // 0, 1, 6, 8
                if (i == N - 1 || !signal[0][i + 1]) {
                    res.append(1);
                    return false;
                }
                if (!signal[1][i + 2]) {
                    res.append(6);
                } else {
                    res.append(signal[2][i + 1] ? 8 : 0);
                }
            }
        }
        return true;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()) / SIZE;
        signal = new boolean[SIZE][N];

        String s = br.readLine();
        int index = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < N; j++) {
                signal[i][j] = s.charAt(index++) == '#';
            }
        }
    }
}
