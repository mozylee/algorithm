package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class prob09184 {
    static int[][][] w = new int[21][21][21];

    public static void main(String[] args) {
        ArrayList<Integer[]> queries = getQueries();
        setDp();
        StringBuilder sb = new StringBuilder();
        for (Integer[] query : queries) {
            sb.append(getQueryString(query));
            if (query[0] <= 0 || query[1] <= 0 || query[2] <= 0)
                sb.append(w[0][0][0]);
            else if (query[0] > 20 || query[1] > 20 || query[2] > 20)
                sb.append(w[20][20][20]);
            else
                sb.append(w[query[0]][query[1]][query[2]]);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static String getQueryString(Integer[] query) {
        return "w(" + query[0] + ", " + query[1] + ", " + query[2] + ") = ";
    }

    static void setDp() {
        for (int a = 0; a <= 20; a++) {
            for (int b = 0; b <= 20; b++) {
                for (int c = 0; c <= 20; c++) {
                    int result;
                    if (a == 0 || b == 0 || c == 0)
                        result = 1;
                    else if (a < b && b < c)
                        result = w[a][b][c - 1] + w[a][b - 1][c - 1] - w[a][b - 1][c];
                    else
                        result = w[a - 1][b][c] + w[a - 1][b - 1][c] + w[a - 1][b][c - 1] - w[a - 1][b - 1][c - 1];
                    w[a][b][c] = result;
                }
            }
        }
    }

    static ArrayList<Integer[]> getQueries() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            ArrayList<Integer[]> queries = new ArrayList<>();
            StringTokenizer st;
            while (true) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if (a == -1 && b == -1 && c == -1)
                    break;
                queries.add(new Integer[] { a, b, c });
            }
            return queries;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
