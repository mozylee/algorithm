package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class prob17143 {
    static int R, C;
    static int[][] map;
    static HashMap<Integer, Shark> sharks = new HashMap<>();

    public static void main(String[] args) {
        input();
        int sizes = 0;
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                if (map[j][i] > 0) {
                    sizes += sharks.get(map[j][i]).z;
                    sharks.remove(map[j][i]);
                    map[j][i] = 0;
                    break;
                }
            }
            moveSharks();
        }
        System.out.println(sizes);
    }

    static void moveSharks() {
        ArrayList<Integer> needDelete = new ArrayList<>();
        for (Integer key : sharks.keySet()) {
            Shark shark = sharks.get(key);
            map[shark.r][shark.c] = 0;
            shark.move(R, C);
        }

        for (Integer key : sharks.keySet()) {
            Shark shark = sharks.get(key);
            if (map[shark.r][shark.c] > 0) {
                Shark shark2 = sharks.get(map[shark.r][shark.c]);
                if (shark.z > shark2.z) {
                    needDelete.add(map[shark.r][shark.c]);
                } else {
                    needDelete.add(key);
                    continue;
                }
            }
            map[shark.r][shark.c] = key;
        }
        for (Integer integer : needDelete) {
            sharks.remove(integer);
        }
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            map = new int[R][C];
            int count = 1;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                int s = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) - 1;
                if (d == 2) {
                    d = 1;
                } else if (d == 1) {
                    d = 2;
                }
                if (d % 2 == 0) {
                    s %= (R - 1) / 2;
                } else {
                    s %= (C - 1) / 2;
                }
                int z = Integer.parseInt(st.nextToken());
                sharks.put(count, new Shark(r, c, s, d, z));
                map[r][c] = count++;
            }
        } catch (Exception e) {
        }
    }
}

class Shark {
    static final int[][] DIRECTIONS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    int r, c, s, d, z;

    Shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }

    void move(int R, int C) {
        r += DIRECTIONS[d][0] * s;
        c += DIRECTIONS[d][1] * s;
        while (!isVaild(R, C)) {
            if (r > R - 1) {
                r = -(r - R);
            } else if (r < 0) {
                r *= -1;
            }

            if (c > C - 1) {
                c = -(c - C);
            } else if (c < 0) {
                c *= -1;
            }
            d = (d + 2) % 4;
        }
    }

    boolean isVaild(int R, int C) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
