package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob22868 {
    private static int N, M;
    private static int S, E;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static int[] traces;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) throws IOException {
        input();

        solve();

        System.out.println(count);
    }

    private static void solve() {
        traces = new int[N + 1];
        visited = new boolean[N + 1];
        bfs(S, E);

        visited = new boolean[N + 1];
        int trace = E;
        while (trace != S) {
            visited[trace] = true;
            trace = traces[trace];
        }

        bfs(E, S);
    }

    private static void bfs(int start, int end) {
        Queue<Trial> queue = new LinkedList<>();
        queue.add(new Trial(start, 0));
        visited[start] = false;

        while (!queue.isEmpty()) {
            Trial now = queue.poll();

            for (int next : graph.get(now.vertex)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                traces[next] = now.vertex;

                if (next == end) {
                    count += now.distance + 1;
                    return;
                }
                queue.add(new Trial(next, now.distance + 1));
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        for (int i = 1; i <= N; i++) {
            graph.get(i).sort(null);
        }
        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
    }

    private static final class Trial {
        int vertex, distance;

        Trial(int next, int distance) {
            this.vertex = next;
            this.distance = distance;
        }
    }
}