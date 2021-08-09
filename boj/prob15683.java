package boj;

import java.io.*;
import java.util.*;

public class prob15683 {
    static int N, M, area, count, min = Integer.MAX_VALUE;
    static int[][] origin;
    static int[][] map;
    static CCTV[] CCTVs = new CCTV[8];
    static int[] directions = new int[8];
    static final int[][] DIRECTIONS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) {
        getMap();
        dfs(0);
        System.out.println(min);
    }

    static void dfs(int c) {
        if (min == 0) {
            return;
        }
        if (c == count) {
            min = Math.min(min, checkMap());
            return;
        }
        for (int i = 0; i < 4; i++) {
            directions[c] = i;
            dfs(c + 1);
        }
    }

    static int checkMap() {
        copyMap();
        int ans = area;
        for (int i = 0; i < count; i++)
            ans -= checkCCTV(CCTVs[i], directions[i]);
        return ans;
    }

    static int checkCCTV(CCTV p, int d) {
        int c = checkForward(p.x + DIRECTIONS[d][0], p.y + DIRECTIONS[d][1], d);
        switch (p.kind) {
            case 2:
                c += checkForward(p.x + DIRECTIONS[(d + 2) % 4][0], p.y + DIRECTIONS[(d + 2) % 4][1], (d + 2) % 4);
                break;
            case 3:
                c += checkForward(p.x + DIRECTIONS[(d + 1) % 4][0], p.y + DIRECTIONS[(d + 1) % 4][1], (d + 1) % 4);
                break;
            case 4:
                c += checkForward(p.x + DIRECTIONS[(d + 1) % 4][0], p.y + DIRECTIONS[(d + 1) % 4][1], (d + 1) % 4);
                c += checkForward(p.x + DIRECTIONS[(d + 3) % 4][0], p.y + DIRECTIONS[(d + 3) % 4][1], (d + 3) % 4);
                break;
            case 5:
                c += checkForward(p.x + DIRECTIONS[(d + 1) % 4][0], p.y + DIRECTIONS[(d + 1) % 4][1], (d + 1) % 4);
                c += checkForward(p.x + DIRECTIONS[(d + 2) % 4][0], p.y + DIRECTIONS[(d + 2) % 4][1], (d + 2) % 4);
                c += checkForward(p.x + DIRECTIONS[(d + 3) % 4][0], p.y + DIRECTIONS[(d + 3) % 4][1], (d + 3) % 4);
                break;
        }
        return c;
    }

    static int checkForward(int x, int y, int d) {
        if (!isValid(x, y))
            return 0;
        boolean check = map[x][y] == 0;
        map[x][y] = -1;
        return (check ? 1 : 0) + checkForward(x + DIRECTIONS[d][0], y + DIRECTIONS[d][1], d);
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M && map[x][y] < 6;
    }

    static int[][] copyMap() {
        for (int i = 0; i < N; i++)
            map[i] = Arrays.copyOf(origin[i], M);
        return map;
    }

    static void getMap() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            area = N * M;
            origin = new int[N][M];
            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    origin[i][j] = Integer.parseInt(st.nextToken());
                    if (origin[i][j] == 0)
                        continue;
                    else
                        area--;
                    if (origin[i][j] < 6)
                        CCTVs[count++] = new CCTV(i, j, origin[i][j]);
                }
            }
        } catch (Exception e) {
        }
    }

    static class CCTV {
        int x, y, kind;

        CCTV(int x, int y, int k) {
            this.x = x;
            this.y = y;
            kind = k;
        }
    }
}