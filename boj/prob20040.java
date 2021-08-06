package boj;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob20040 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int M;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        input();
        StringTokenizer st;
        int time = 0;
        for (int i = 0; i < M; i++) {
            time++;
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if (!union(n1, n2)) {
                System.out.println(time);
                System.exit(0);
                break;
            }
        }
        System.out.println(0);
    }

    static boolean union(int n1, int n2) {
        int parent1 = find(n1);
        int parent2 = find(n2);
        if (parent1 == parent2)
            return false;
        if (parent1 < parent2) {
            int temp = parent1;
            parent1 = parent2;
            parent2 = temp;
        }
        parents[parent2] = parent1;
        return true;
    }

    static int find(int n) {
        if (parents[n] == n)
            return n;
        return parents[n] = parents[find(parents[n])];
    }

    static void input() {
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            parents = new int[N];
            for (int i = 0; i < N; i++) {
                parents[i] = i;
            }
            M = Integer.parseInt(st.nextToken());
        } catch (Exception e) {
            System.out.println("ERROR!!!");
        }
    }
}
