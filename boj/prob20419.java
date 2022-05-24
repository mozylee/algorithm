package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob20419 {
    private static int R, C, K;
    private static int[][] board;

    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    private static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(canEscape() ? "Yes" : "No");
    }

    private static boolean canEscape() {
        Queue<Trial> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[R][C][K + 1][K + 1];
        queue.add(new Trial(0, 0, K, K));

        while (!queue.isEmpty()) {
            Trial now = queue.poll();
            if (isDone(now.x, now.y)) {
                return true;
            }

            int direction = board[now.x][now.y];
            int nx = now.x + dx[direction];
            int ny = now.y + dy[direction];
            if (isDone(nx, ny)) {
                return true;
            }

            if (!isOOB(nx, ny) && !visited[nx][ny][now.left][now.right]) {
                visited[nx][ny][now.left][now.right] = true;
                queue.add(new Trial(nx, ny, now.left, now.right));
            }

            if (now.right > 0) {
                int right = (direction + RIGHT) % 4;
                int rightX = now.x + dx[right];
                int rightY = now.y + dy[right];
                if (isDone(rightX, rightY)) {
                    return true;
                }

                if (!isOOB(rightX, rightY) && !visited[rightX][rightY][now.left][now.right - 1]) {
                    visited[rightX][rightY][now.left][now.right - 1] = true;
                    queue.add(new Trial(rightX, rightY, now.left, now.right - 1));
                }
            }

            if (now.left > 0) {
                int left = (direction + LEFT) % 4;
                int leftX = now.x + dx[left];
                int leftY = now.y + dy[left];
                if (isDone(leftX, leftY)) {
                    return true;
                }

                if (!isOOB(leftX, leftY) && !visited[leftX][leftY][now.left - 1][now.right]) {
                    visited[leftX][leftY][now.left - 1][now.right] = true;
                    queue.add(new Trial(leftX, leftY, now.left - 1, now.right));
                }
            }
        }
        return false;
    }

    private static boolean isDone(int x, int y) {
        return x == R - 1 && y == C - 1;
    }

    private static boolean isOOB(int x, int y) {
        return x < 0 || x >= R || y < 0 || y >= C;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                int direction = 0;
                switch (line.charAt(j)) {
                    case 'U':
                        direction = UP;
                        break;
                    case 'R':
                        direction = RIGHT;
                        break;
                    case 'D':
                        direction = DOWN;
                        break;
                    case 'L':
                        direction = LEFT;
                        break;
                }
                board[i][j] = direction;
            }
        }
    }

    private static final class Trial {
        int x, y;
        int left, right;

        Trial(int x, int y, int left, int right) {
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }
    }
}
