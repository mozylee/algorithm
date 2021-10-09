package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class prob01829 {
    private static int numberOfArea;
    private static int maxSizeOfOneArea;
    private static boolean[][] visited;
    private static int[] dx;
    private static int[] dy;
    private static int M, N;

    public static int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        dx = new int[] { 0, 0, -1, 1 };
        dy = new int[] { -1, 1, 0, 0 };
        M = m;
        N = n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || picture[i][j] == 0)
                    continue;
                visited[i][j] = true;
                bfs(i, j, picture[i][j], picture);
            }
        }
        return new int[] { numberOfArea, maxSizeOfOneArea };
    }

    private static void bfs(int x, int y, int pixel, int[][] picture) {
        Queue<Coord> queue = new LinkedList<>();
        queue.add(new Coord(x, y));
        numberOfArea++;
        int area = 1;
        while (!queue.isEmpty()) {
            Coord now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (isOutOfBounds(nx, ny) || visited[nx][ny] || picture[nx][ny] != pixel)
                    continue;
                visited[nx][ny] = true;
                queue.add(new Coord(nx, ny));
                area++;
            }
        }
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
    }

    private static boolean isOutOfBounds(int nx, int ny) {
        return !(nx >= 0 && nx < M && ny >= 0 && ny < N);
    }

    static class Coord {
        int x, y;

        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
                { 0, 0, 0, 3 } };
        System.out.println(Arrays.toString(solution(m, n, picture)));
        // {4,5}
    }
}
