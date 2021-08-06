package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob14891 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int GEAR_SIZE = 8, GEAR_TOTAL = 4;
    private static Gear[] gears = new Gear[GEAR_TOTAL];

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        input();
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int gearNumber = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            turn(gearNumber - 1, direction);
        }
        int score = 0;
        for (int i = 0; i < GEAR_TOTAL; i++) {
            score += gears[i].getTop() * (int) Math.pow(2, i);
        }
        System.out.println(score);
    }

    private static void turn(int n, int d) {
        boolean[] check = check();
        gears[n].turn(d);
        switch (n) {
            case 0:
                for (int i = 1; i <= check.length; i++) {
                    if (!check[i - 1])
                        break;
                    gears[n + i].turn(-d);
                    d *= -1;
                }
                return;
            case 1:
                if (check[0])
                    gears[0].turn(-d);
                if (check[1]) {
                    gears[2].turn(-d);
                    if (check[2])
                        gears[3].turn(d);
                }
                return;
            case 2:
                if (check[2])
                    gears[3].turn(-d);
                if (check[1]) {
                    gears[1].turn(-d);
                    if (check[0])
                        gears[0].turn(d);
                }
                return;
            case 3:
                for (int i = check.length - 1; i >= 0; i--) {
                    if (!check[i])
                        break;
                    gears[i].turn(-d);
                    d *= -1;
                }
                return;
        }
    }

    private static boolean[] check() {
        boolean[] c = new boolean[GEAR_TOTAL - 1];
        for (int i = 0; i < GEAR_TOTAL - 1; i++)
            c[i] = checkRight(i);
        return c;
    }

    private static boolean checkRight(int n) {
        return n < GEAR_TOTAL - 1 && gears[n].getRight() != gears[n + 1].getLeft();
    }

    private static void input() {
        try {
            for (int i = 0; i < GEAR_TOTAL; i++) {
                String line = br.readLine();
                int[] values = new int[GEAR_SIZE];
                for (int j = 0; j < GEAR_SIZE; j++)
                    values[j] = line.charAt(j) - '0';
                gears[i] = new Gear(values);
            }
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }

    static class Gear {
        private static final int GEAR_SIZE = 8;
        private int[] values = new int[GEAR_SIZE];
        private int top = 0, left = 6, right = 2;

        Gear(int[] v) {
            for (int i = 0; i < GEAR_SIZE; i++) {
                values[i] = v[i];
            }
        }

        void turn(int direction) {
            direction *= -1;
            top = (top + direction + GEAR_SIZE) % GEAR_SIZE;
            left = (left + direction + GEAR_SIZE) % GEAR_SIZE;
            right = (right + direction + GEAR_SIZE) % GEAR_SIZE;
        }

        int getTop() {
            return values[top];
        }

        int getLeft() {
            return values[left];
        }

        int getRight() {
            return values[right];
        }
    }
}
