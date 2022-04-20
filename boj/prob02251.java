package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class prob02251 {
    private static int A, B, C;

    public static void main(String[] args) throws IOException {
        input();

        StringBuilder sb = new StringBuilder();
        for (int c : bfs()) {
            sb.append(c).append(" ");
        }
        System.out.println(sb);
    }

    private static TreeSet<Integer> bfs() {
        Queue<Trial> queue = new LinkedList<>();
        queue.add(new Trial(0, 0, C));
        TreeSet<Integer> ret = new TreeSet<>();
        ret.add(C);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(queue.peek().hashCode());
        while (!queue.isEmpty()) {
            Trial now = queue.poll();

            for (Trial next : now.getCases()) {
                if (visited.contains(next.hashCode())) {
                    continue;
                }
                visited.add(next.hashCode());
                if (next.A == 0) {
                    ret.add(next.C);
                }
                queue.add(next);
            }
        }
        return ret;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Trial.UPPER_A = A;
        Trial.UPPER_B = B;
        Trial.UPPER_C = C;
    }

    private static class Trial {
        static int UPPER_A, UPPER_B, UPPER_C;
        int A, B, C;

        Trial(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }

        public Trial[] getCases() {
            Trial[] ret = new Trial[6];
            // A->B,C
            ret[0] = new Trial(A >= UPPER_B - B ? A - (UPPER_B - B) : 0, A >= UPPER_B - B ? UPPER_B : B + A, C);
            ret[1] = new Trial(A >= UPPER_C - C ? A - (UPPER_C - C) : 0, B, A >= UPPER_C - C ? UPPER_C : C + A);
            // B->A,C
            ret[2] = new Trial(B >= UPPER_A - A ? UPPER_A : A + B, B >= UPPER_A - A ? B - (UPPER_A - A) : 0, C);
            ret[3] = new Trial(A, B >= UPPER_C - C ? B - (UPPER_C - C) : 0, B >= UPPER_C - C ? UPPER_C : C + B);
            // C->A,B
            ret[4] = new Trial(C >= UPPER_A - A ? UPPER_A : A + C, B, C >= UPPER_A - A ? C - (UPPER_A - A) : 0);
            ret[5] = new Trial(A, C >= UPPER_B - B ? UPPER_B : B + C, C >= UPPER_B - B ? C - (UPPER_B - B) : 0);
            return ret;
        }

        @Override
        public int hashCode() {
            return A * 1_000_000 + B * 1000 + C;
        }
    }
}
