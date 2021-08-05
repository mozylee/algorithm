package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob03190 {
    static int N;
    static int r, c, d, time;
    static int[][] DIRECTION = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    static int[][] map;
    static Queue<Point> snake = new LinkedList<>();
    static Queue<Direction> directions = new LinkedList<>();

    public static void main(String[] args) {
        input();
        snake();
        System.out.println(time);
    }

    public static void snake() {
        while (true) {
            time++;
            move();
            if (!isValid())
                break;
            if (!isApple()) {
                Point tail = snake.poll();
                map[tail.x][tail.y] = 0;
            }
            snake.add(new Point(r, c));
            map[r][c] = 2;
            if (!directions.isEmpty() && directions.peek().time == time) {
                Direction d = directions.poll();
                if (d.isRight)
                    turnRight();
                else
                    turnLeft();
            }
        }
    }

    public static boolean isValid() {
        return r >= 0 && c >= 0 && r < N && c < N && map[r][c] != 2;
    }

    public static boolean isApple() {
        return map[r][c] == 1;
    }

    public static boolean isSnake() {
        return map[r][c] == 2;
    }

    public static void move() {
        r += DIRECTION[d][0];
        c += DIRECTION[d][1];
    }

    public static void turnRight() {
        d = (d + 1) % 4;
    }

    public static void turnLeft() {
        d = (d + 3) % 4;
    }

    public static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            int K = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x - 1][y - 1] = 1;
            }

            int count = Integer.parseInt(br.readLine());
            for (int i = 0; i < count; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                boolean isRight = st.nextToken().equals("D");
                directions.add(new Direction(x, isRight));
            }
            map[0][0] = 2;
            snake.add(new Point(0, 0));
            br.close();
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Direction {
        int time;
        boolean isRight;

        Direction(int time, boolean isRight) {
            this.time = time;
            this.isRight = isRight;
        }
    }
}
