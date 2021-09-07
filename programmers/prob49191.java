package programmers;

public class prob49191 {
    static int N;
    static boolean[][] map;

    public static void main(String[] args) {
        // 2
        System.out.println(solution(5, new int[][] { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } }));
    }

    public static int solution(int n, int[][] results) {
        input(n, results);
        floydWashall();
        return getStudentAmount();
    }

    static int getStudentAmount() {
        int amount = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                if (!map[i][j] && !map[j][i]) {
                    count++;
                }
            }
            if (count < 1)
                amount++;
        }
        return amount;
    }

    static void floydWashall() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][k] && map[k][j])
                        map[i][j] = true;
                }
            }
        }
    }

    static void input(int n, int[][] results) {
        N = n;
        map = new boolean[N][N];
        for (int i = 0; i < results.length; i++) {
            map[results[i][0] - 1][results[i][1] - 1] = true;
        }
    }

}
