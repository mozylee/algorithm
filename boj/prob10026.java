// Point때문에 자꾸 경고 표시 떠서 일단 밑에 있는 Point 클래스는 주석처리

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob10026 {
    static int n, nextX, nextY;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static char[][] picture;
    static boolean[][] visited;
    static Point now;

    static void dfs(char start, int x, int y) {
        if (visited[x][y])
            return;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            nextX = x + dx[i];
            nextY = y + dy[i];
            if (isValid(nextX, nextY) && picture[nextX][nextY] == start)
                dfs(start, nextX, nextY);

        }
    }

    static void dfsWeak(int x, int y) {
        if (visited[x][y])
            return;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            nextX = x + dx[i];
            nextY = y + dy[i];
            if (isValid(nextX, nextY) && (picture[nextX][nextY] == 'R' || picture[nextX][nextY] == 'G'))
                dfsWeak(nextX, nextY);
        }
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        picture = new char[n][n];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                picture[i][j] = temp.charAt(j);
            }
        }
        visited = new boolean[n][n];
        int normal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(picture[i][j], i, j);
                    normal++;
                }
            }
        }

        visited = new boolean[n][n];
        int colorWeakness = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (picture[i][j] == 'B')
                        dfs(picture[i][j], i, j);
                    else
                        dfsWeak(i, j);
                    colorWeakness++;
                }
            }
        }

        System.out.println(normal + " " + colorWeakness);

    }
}

// class Point {
//     int x, y;

//     Point(int x, int y) {
//         this.x = x;
//         this.y = y;
//     }
// }