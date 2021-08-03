package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob14500 {
    static int N, M, max = Integer.MIN_VALUE;
    static int[][] board;
    // 블록모양 참고 (https://sbrngm.tistory.com/143)
    static final boolean[][][] BLOCKS = { { { true, true }, { true, true } }, { { true, true, true, true }, },
            { { true }, { true }, { true }, { true } },

            { { true }, { true, true }, { false, true } }, { { false, true }, { true, true }, { true } },
            { { false, true, true }, { true, true } }, { { true, true }, { false, true, true } },

            { { true, true, true }, { false, true } }, { { false, true }, { true, true }, { false, true } },
            { { true }, { true, true }, { true } }, { { false, true }, { true, true, true } },

            { { true, true, true }, { true } }, { { true }, { true }, { true, true } },
            { { false, false, true }, { true, true, true } }, { { true, true }, { false, true }, { false, true } },
            { { true, true, true }, { false, false, true } }, { { true, true }, { true }, { true } },
            { { true }, { true, true, true } }, { { false, true }, { false, true }, { true, true } }, };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        iterBoard();
        System.out.println(max);
    }

    public static void iterBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < BLOCKS.length; k++) {
                    calculateSum(i, j, k);
                }
            }
        }
    }

    public static void calculateSum(int x, int y, int blockNo) {
        int sum = 0;
        for (int i = 0; i < BLOCKS[blockNo].length; i++) {
            for (int j = 0; j < BLOCKS[blockNo][i].length; j++) {
                if (!isValid(x + i, y + j))
                    return;
                if (!BLOCKS[blockNo][i][j])
                    continue;
                sum += board[x + i][y + j];
            }
        }
        max = Math.max(max, sum);
    }

    public static boolean isValid(int x, int y) {
        return (x >= 0 && y >= 0 && x < N && y < M);
    }
}
