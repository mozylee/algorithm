package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob03967 {
    private static final int SIZE = 12;
    private static int[] hexagram = new int[SIZE];
    private static boolean[] visited = new boolean[SIZE + 1];
    private static StringBuilder hex = new StringBuilder();

    private static final int[][] lines = { { 0, 2, 5, 7 }, { 0, 3, 6, 10 }, { 1, 2, 3, 4 }, { 7, 8, 9, 10 },
            { 1, 5, 8, 11 }, { 4, 6, 9, 11 } };

    public static void main(String[] args) throws IOException {
        input();
        dfs(0);

        System.out.println(hex);
    }

    private static void dfs(int i) {
        if (hex.length() > 0) {
            return;
        }

        if (i == SIZE) {
            if (checkHexagram())
                makeHexagram();
            return;
        }

        if (hexagram[i] != 0) {
            dfs(i + 1);
            return;
        }

        for (int k = 1; k <= SIZE; k++) {
            if (visited[k]) {
                continue;
            }
            visited[k] = true;
            hexagram[i] = k;
            dfs(i + 1);
            visited[k] = false;
            hexagram[i] = 0;
        }
    }

    private static boolean checkHexagram() {
        for (int[] line : lines) {
            int sum = 0;
            for (int index : line) {
                sum += hexagram[index];
            }
            if (sum != 26) {
                return false;
            }
        }
        return true;
    }

    private static void makeHexagram() {
        int index = 0;

        hex.append("....").append(iToC(hexagram[index++])).append("....\n");

        hex.append(".").append(iToC(hexagram[index++])).append(".").append(iToC(hexagram[index++]));
        hex.append(".").append(iToC(hexagram[index++])).append(".").append(iToC(hexagram[index++])).append(".\n");

        hex.append("..").append(iToC(hexagram[index++])).append("...").append(iToC(hexagram[index++])).append("..\n");

        hex.append(".").append(iToC(hexagram[index++])).append(".").append(iToC(hexagram[index++]));
        hex.append(".").append(iToC(hexagram[index++])).append(".").append(iToC(hexagram[index++])).append(".\n");

        hex.append("....").append(iToC(hexagram[index++])).append("....\n");
    }

    private static char iToC(int n) {
        return (char) (n + 'A' - 1);
    }

    private static void input() throws IOException {
        int index = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        for (int i = 0; i < 5; i++) {
            line = br.readLine().replace(".", "");
            for (int j = 0; j < line.length(); j++) {
                hexagram[index] = line.charAt(j) != 'x' ? line.charAt(j) - 'A' + 1 : 0;
                visited[hexagram[index++]] = true;
            }
        }
    }
}
