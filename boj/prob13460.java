package boj;

import java.io.*;
import java.util.*;

public class prob13460 {
    static int N, M;
    static boolean[][] origin;
    static final int[][] DIRECTIONS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static Point red, blue, hole;

    public static void main(String[] args) {
        input();
        System.out.println(bfs(new Case(red, blue, 0)));
    }

    static int bfs(Case start) {
        Queue<Case> queue = new LinkedList<>();
        HashSet<Case> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            Case now = queue.poll();
            boolean[][] nowMap = makeMap();
            for (int i = 0; i < 4; i++) {
                Point[] nextPoints = movePoints(now.red, now.blue, i, nowMap);
                Point nextR = nextPoints[0];
                Point nextB = nextPoints[1];
                Case next = new Case(nextR, nextB, now.count + 1);
                if (nextB.equals(hole) || next.count >= 11)
                    continue;
                if (nextR.equals(hole)) {
                    return now.count + 1;
                }
                if (visited.contains(next))
                    continue;
                queue.add(next);
                visited.add(next);
            }
        }
        return -1;
    }

    static Point[] movePoints(Point r, Point b, int d, boolean[][] map) {
        Point[] points = new Point[2];

        switch (d) {
            case 0:
                if (r.x > b.x) {
                    points[1] = move(b, 0, map);
                    if (!points[1].equals(hole))
                        map[points[1].x][points[1].y] = false;
                    points[0] = move(r, 0, map);
                } else {
                    points[0] = move(r, 0, map);
                    if (!points[0].equals(hole))
                        map[points[0].x][points[0].y] = false;
                    points[1] = move(b, 0, map);
                }
                break;
            case 1:
                if (r.y < b.y) {
                    points[1] = move(b, 1, map);
                    if (!points[1].equals(hole))
                        map[points[1].x][points[1].y] = false;
                    points[0] = move(r, 1, map);
                } else {
                    points[0] = move(r, 1, map);
                    if (!points[0].equals(hole))
                        map[points[0].x][points[0].y] = false;
                    points[1] = move(b, 1, map);
                }
                break;
            case 2:
                if (r.x < b.x) {
                    points[1] = move(b, 2, map);
                    if (!points[1].equals(hole))
                        map[points[1].x][points[1].y] = false;
                    points[0] = move(r, 2, map);
                } else {
                    points[0] = move(r, 2, map);
                    if (!points[0].equals(hole))
                        map[points[0].x][points[0].y] = false;
                    points[1] = move(b, 2, map);
                }
                break;
            case 3:
                if (r.y > b.y) {
                    points[1] = move(b, 3, map);
                    if (!points[1].equals(hole))
                        map[points[1].x][points[1].y] = false;
                    points[0] = move(r, 3, map);
                } else {
                    points[0] = move(r, 3, map);
                    if (!points[0].equals(hole))
                        map[points[0].x][points[0].y] = false;
                    points[1] = move(b, 3, map);
                }
                break;
        }
        map[points[1].x][points[1].y] = true;
        map[points[0].x][points[0].y] = true;
        return points;
    }

    static boolean[][] makeMap() {
        boolean[][] copyMap = new boolean[N][];
        for (int i = 0; i < copyMap.length; i++) {
            copyMap[i] = Arrays.copyOf(origin[i], M);
        }
        return copyMap;
    }

    static boolean isValid(int x, int y, boolean[][] map) {
        return x >= 0 && y >= 0 && x < N && y < M && map[x][y];
    }

    static Point move(Point p, int d, boolean[][] map) {
        int x = p.x;
        int y = p.y;
        int xx = x + DIRECTIONS[d][0];
        int yy = y + DIRECTIONS[d][1];
        if (p.equals(hole)) {
            return hole;
        }
        if (!isValid(xx, yy, map)) {
            return p;
        }
        return move(new Point(xx, yy), d, map);
    }

    static void print(Point r, Point b) {
        HashMap<Boolean, Character> hm = new HashMap<>();
        hm.put(false, '#');
        hm.put(true, '.');

        System.out.println("\nHOLE: " + hole);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == r.x && j == r.y) {
                    System.out.print("R");
                } else if (i == b.x && j == b.y) {
                    System.out.print("B");
                } else
                    System.out.printf("%c", hm.get(origin[i][j]));
            }
            System.out.println();
        }
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] inputs = br.readLine().split(" ");
            N = Integer.parseInt(inputs[0]);
            M = Integer.parseInt(inputs[1]);
            origin = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    if (line.charAt(j) == 'O') {
                        hole = new Point(i, j);
                    } else if (line.charAt(j) == 'R') {
                        red = new Point(i, j);
                    } else if (line.charAt(j) == 'B') {
                        blue = new Point(i, j);
                    }
                    origin[i][j] = line.charAt(j) != '#';
                }
            }
        } catch (Exception e) {
        }
    }

    static class Case {
        Point red, blue;
        int count;

        Case(Point r, Point b) {
            this(r, b, 0);
        }

        Case(Point r, Point b, int count) {
            red = r;
            blue = b;
            this.count = count;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Case))
                return false;
            Case c = (Case) obj;
            return this.red.equals(c.red) && this.blue.equals(c.blue);
        }

        @Override
        public String toString() {
            return count + ": " + red + ", " + blue;
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point))
                return false;
            Point p = (Point) obj;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
