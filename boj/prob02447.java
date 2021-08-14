package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class prob02447 {
    static boolean[][] stars;
    static int N;

    public static void main(String[] args) {
        init();
        recursive(0, 0, N);
        print();
    }

    static void recursive(int x, int y, int size) {
        if (size == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    stars[x + i][y + j] = i == j && i + j == 2 ? false : true;
                }
            }
            return;
        }
        size /= 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j && i + j == 2)
                    continue;
                recursive(x + (i * size), y + (j * size), size);
            }
        }

    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (boolean[] bs : stars) {
            for (boolean b : bs) {
                sb.append(b ? "*" : " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            stars = new boolean[N][N];
        } catch (Exception e) {
        }
    }
}
