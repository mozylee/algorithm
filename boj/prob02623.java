package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class prob02623 {
    static int N, M;
    static int[] singers;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            if (singers[i] == 0)
                queue.offer(i);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append('\n');
            for (int next : graph.get(now))
                if (--singers[next] == 0)
                    queue.offer(next);
        }
        for (int s : singers)
            if (s > 0) {
                System.out.println(0);
                return;
            }

        System.out.println(sb);
    }

    public static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            singers = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int count = Integer.parseInt(st.nextToken());
                int parent = Integer.parseInt(st.nextToken());
                for (int j = 1; j < count; j++) {
                    int child = Integer.parseInt(st.nextToken());
                    singers[child]++;
                    graph.get(parent).add(child);
                    parent = child;
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }
}
