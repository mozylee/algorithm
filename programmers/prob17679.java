package programmers;

import java.util.HashSet;
import java.util.Stack;

public class prob17679 {
    public static int solution(int m, int n, String[] b) {
        int[][] board = strToIntArr(b);
        int answer = 0;
        HashSet<Block> willPang = new HashSet<>();
        while (true) {
            willPang.clear();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 0)
                        continue;
                    if (!checkOthers(board, i, j, m, n))
                        continue;
                    addPang(willPang, i, j);
                }
            }
            if (willPang.size() == 0)
                break;
            answer += willPang.size();
            pang(board, willPang);
            drop(board, m, n);
        }
        return answer;
    }

    private static void addPang(HashSet<Block> willPang, int i, int j) {
        for (int k = 0; k < 2; k++) {
            for (int k2 = 0; k2 < 2; k2++) {
                willPang.add(new Block(i + k, j + k2));
            }
        }
    }

    private static void drop(int[][] board, int m, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (board[i][j] > 0) {
                    stack.push(board[i][j]);
                    board[i][j] = 0;
                }
            }
            int bottom = m - 1;
            while (!stack.isEmpty()) {
                board[bottom--][j] = stack.pop();
            }
            stack.clear();
        }
    }

    private static void pang(int[][] board, HashSet<Block> willPang) {
        for (Block b : willPang) {
            board[b.x][b.y] = 0;
        }
    }

    private static boolean checkOthers(int[][] board, int r, int c, int m, int n) {
        int block = board[r][c];
        for (int i = r; i <= r + 1; i++) {
            for (int j = c; j <= c + 1; j++) {
                if (isOutOfBounds(i, j, m, n) || board[i][j] != block)
                    return false;
            }
        }
        return true;
    }

    private static boolean isOutOfBounds(int i, int j, int m, int n) {
        return !(0 <= i && i < m && 0 <= j && j < n);
    }

    private static int[][] strToIntArr(String[] b) {
        int[][] ret = new int[b.length][b[0].length()];
        for (int i = 0; i < ret.length; i++)
            for (int j = 0; j < ret[0].length; j++)
                ret[i][j] = b[i].charAt(j) - 64;

        return ret;
    }

    public static void main(String[] args) {
        int[] m = { 4, 6 };
        int[] n = { 5, 6 };
        String[][] board = { { "CCBDE", "AAADE", "AAABF", "CCBBF" },
                { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" } };

        for (int i = 0; i < 2; i++) {
            System.out.println(solution(m[i], n[i], board[i]));
        }
    }

    static class Block {
        int x, y;

        Block(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x * 10000 + y;
        }

        @Override
        public boolean equals(Object obj) {
            Block b = (Block) obj;
            return this.x == b.x && this.y == b.y;
        }
    }
}
// 14
// 15