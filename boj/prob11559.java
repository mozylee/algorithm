package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class prob11559 {
    private static final int EMPTY = '.';
    private static final int WIDTH = 6;
    private static final int HEIGHT = 12;
    private static final int DIRECTION = 4;
    private static int[][] board = new int[HEIGHT][WIDTH];
    private static boolean[][] visited = new boolean[HEIGHT][WIDTH];
    private static ArrayList<Point> willPop = new ArrayList<>();
    private static int[] dh = { 0, 0, 1, -1 };
    private static int[] dw = { 1, -1, 0, 0 };

    public static void main(String[] args) {
        input();
        int count = 0;
        while (true) {
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    if (visited[i][j] || board[i][j] == 0)
                        continue;
                    bfs(i, j);
                }
            }
            if (willPop.isEmpty())
                break;
            popPuyo();
            count++;
            dropPuyo();
            initVisited();
        }
        System.out.println(count);
    }

    private static void initVisited() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static void bfs(int h, int w) {
        visited[h][w] = true;
        HashSet<Point> checked = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(h, w));
        final int PUYO = board[h][w];
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            checked.add(now);
            for (int i = 0; i < DIRECTION; i++) {
                int nh = now.h + dh[i];
                int nw = now.w + dw[i];
                if (isOutOfBound(nh, nw))
                    continue;
                if (visited[nh][nw])
                    continue;
                if (board[nh][nw] != PUYO)
                    continue;
                visited[nh][nw] = true;
                Point next = new Point(nh, nw);
                queue.add(next);
            }
        }
        if (checked.size() < 4)
            return;
        willPop.addAll(checked);
    }

    private static void dropPuyo() {
        for (int i = 0; i < WIDTH; i++) {
            dropLine(i);
        }
    }

    private static void dropLine(int i) {
        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < HEIGHT; j++) {
            if (board[j][i] != 0)
                stack.push(board[j][i]);
            board[j][i] = 0;
        }
        int j = 0;
        while (!stack.isEmpty()) {
            board[HEIGHT - 1 - j++][i] = stack.pop();
        }
    }

    private static void popPuyo() {
        for (Point p : willPop) {
            board[p.h][p.w] = 0;
        }
        willPop.clear();
    }

    private static boolean isOutOfBound(int h, int w) {
        return !(0 <= w && w < WIDTH && 0 <= h && h < HEIGHT);
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int i = 0; i < HEIGHT; i++) {
                String line = br.readLine();
                for (int j = 0; j < WIDTH; j++) {
                    board[i][j] = line.charAt(j) - EMPTY;
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR!!");
        }
    }

    static class Point {
        int h, w;

        Point(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
}
