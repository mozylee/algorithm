package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class prob20166 {
    private static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1, };
    private static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

    private static int N, M;
    private static int MAX_LENGTH;
    private static char[][] board;
    private static String[] query;

    private static HashMap<String, Integer> godsStrings = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();

        getGodsStrings();

        System.out.println(processQueries());
    }

    private static void getGodsStrings() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(board[i][j]);
                dfs(i, j, sb, 1);
            }
        }
    }

    private static void dfs(int x, int y, StringBuilder sb, int length) {
        String s = sb.toString();
        godsStrings.put(s, godsStrings.containsKey(s) ? godsStrings.get(s) + 1 : 1);

        if (length >= MAX_LENGTH) {
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nx = (x + dx[i] + N) % N;
            int ny = (y + dy[i] + M) % M;

            sb.append(board[nx][ny]);
            dfs(nx, ny, sb, length + 1);
            sb.deleteCharAt(length);
        }
    }

    private static StringBuilder processQueries() {
        StringBuilder sb = new StringBuilder();
        for (String q : query) {
            sb.append(godsStrings.containsKey(q) ? godsStrings.get(q) : 0).append("\n");
        }
        return sb;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int K = Integer.parseInt(st.nextToken());
        query = new String[K];
        for (int i = 0; i < K; i++) {
            query[i] = br.readLine();
            MAX_LENGTH = Math.max(query[i].length(), MAX_LENGTH);
        }
    }
}
