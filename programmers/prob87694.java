package programmers;

import java.util.LinkedList;
import java.util.Queue;

// UNSOLVED!!!!!!!!!!!!!!
public class prob87694 {
    private static final int MAX = 51;

    private static boolean[][] map;
    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { -1, 1, 0, 0 };

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        initMap(rectangle);
        boolean[][] visited = new boolean[MAX][MAX];
        visited[characterX][characterY] = true;
        Queue<Trial> queue = new LinkedList<>();
        queue.add(new Trial(characterX, characterY, 0));

        while (!queue.isEmpty()) {
            // System.out.println(queue);
            Trial now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (isOOB(nx, ny) || map[nx][ny] || visited[nx][ny]) {
                    continue;
                }
                if (nx == itemX && ny == itemY) {
                    return now.time + 1;
                }
                visited[nx][ny] = true;
                queue.add(new Trial(nx, ny, now.time + 1));
            }
        }
        return -1;
    }

    private static boolean isOOB(int x, int y) {
        return x < 0 || x >= MAX + 1 || y < 0 || y >= MAX + 1;
    }

    private static void initMap(int[][] rectangle) {
        map = new boolean[MAX + 1][MAX + 1];
        for (int[] is : rectangle) {
            for (int i = is[0] + 1; i < is[2] - 1; i++) {
                for (int j = is[1] + 1; j < is[3] - 1; j++) {
                    map[i][j] = true;
                }
            }
        }
    }

    private static final class Trial {
        int x, y, time;

        Trial(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ":" + time + ")";
        }
    }

    public static void main(String[] args) {
        int[][][] rectangle = { { { 1, 1, 7, 4 }, { 3, 2, 5, 5 }, { 4, 3, 6, 9 }, { 2, 6, 8, 8 } },
                { { 1, 1, 8, 4 }, { 2, 2, 4, 9 }, { 3, 6, 9, 8 }, { 6, 3, 7, 7 } }, { { 1, 1, 5, 7 } },
                { { 2, 1, 7, 5 }, { 6, 4, 10, 10 } }, { { 2, 2, 5, 5 }, { 1, 3, 6, 4 }, { 3, 1, 4, 6 } } };
        int[] characterX = { 1, 9, 1, 3, 1 };
        int[] characterY = { 3, 7, 1, 1, 4 };
        int[] itemX = { 7, 6, 4, 7, 6 };
        int[] itemY = { 8, 1, 7, 10, 3 };
        // 17
        // 11
        // 9
        // 15
        // 10

        for (int i = 0; i < itemY.length; i++) {
            System.out.println(solution(rectangle[i], characterX[i], characterY[i], itemX[i], itemY[i]));
        }
    }
}
