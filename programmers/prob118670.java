package programmers;

import java.util.Deque;
import java.util.LinkedList;

public class prob118670 {
    private static final String EMPTY = "", ROTATE = "Rotate", SHIFTROW = "ShiftRow";
    private static int R, C;

    public static int[][] solution(int[][] rc, String[] operations) {
        String before = "";
        int count = 0;
        R = rc.length;
        C = rc[0].length;

        RC a = new RC(rc);

        for (String op : operations) {
            if (before.equals(EMPTY) || before.equals(op)) {
                before = op;
                count++;
                continue;
            }
            doOperation(getOtherOperation(op), a, count);
            before = op;
            count = 1;
        }
        doOperation(before, a, count);
        return a.getArray2D();
    }

    private static void doOperation(String op, RC rc, int count) {
        switch (op) {
            case ROTATE:
                rotate(rc, count);
                // print(rc);
                break;
            case SHIFTROW:
                shiftRow(rc, count);
                // print(rc);
                break;
        }
    }

    private static void rotate(RC rc, int count) {
        for (int i = 0; i < count; i++) {
            rc.center.getFirst().addFirst(rc.left.pollFirst());
            rc.right.addFirst(rc.center.getFirst().pollLast());
            rc.center.getLast().addLast(rc.right.pollLast());
            rc.left.addLast(rc.center.getLast().pollFirst());
        }
    }

    private static void shiftRow(RC rc, int count) {
        for (int i = 0; i < count; i++) {
            rc.left.addFirst(rc.left.pollLast());
            rc.right.addFirst(rc.right.pollLast());
            rc.center.addFirst(rc.center.pollLast());
        }
    }

    private static String getOtherOperation(String op) {
        return op.equals(ROTATE) ? SHIFTROW : ROTATE;
    }

    private static final class RC {
        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> right = new LinkedList<>();
        Deque<Deque<Integer>> center = new LinkedList<>();

        int R, C;

        RC(int[][] rc) {
            R = rc.length;
            C = rc[0].length;

            for (int i = 0; i < R; i++) {
                left.add(rc[i][0]);
                right.add(rc[i][C - 1]);
            }

            for (int i = 0; i < R; i++) {
                center.add(new LinkedList<>());
                for (int j = 1; j < C - 1; j++) {
                    center.getLast().add(rc[i][j]);
                }
            }
        }

        int[][] getArray2D() {
            int[][] arr2d = new int[R][C];

            for (int i = 0; i < R; i++) {
                arr2d[i][0] = left.pollFirst();
                arr2d[i][C - 1] = right.pollFirst();
            }

            int index = 0;
            for (Deque<Integer> line : center) {
                int j = 1;
                for (int value : line) {
                    arr2d[index][j++] = value;
                }
                index++;
            }

            return arr2d;
        }
    }

    public static void main(String[] args) {
        int[][][] rc = { { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
                { { 8, 6, 3 }, { 3, 3, 7 }, { 8, 4, 9 } },
                { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } } };
        String[][] operations = { { "Rotate", "ShiftRow" },
                { "Rotate", "ShiftRow", "ShiftRow" }, // R1 , S2 // Rotate
                { "ShiftRow", "Rotate", "ShiftRow", "Rotate" } };

        // {{8, 9, 6}, {4, 1, 2}, {7, 5, 3}}
        // {{8, 3, 3}, {4, 9, 7}, {3, 8, 6}}
        // {{1, 6, 7 ,8}, {5, 9, 10, 4}, {2, 3, 12, 11}}

        for (int i = 0; i < operations.length; i++) {
            print(solution(rc[i], operations[i]));
        }
    }

    private static void print(int[][] solution) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.printf("%2d ", solution[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
