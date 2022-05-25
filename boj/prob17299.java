package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class prob17299 {
    private static int N;
    private static int[] A;
    private static int[] F = new int[1_000_000 + 1];
    private static int[] ret;

    public static void main(String[] args) throws IOException {
        input();

        Stack<Item> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && F[stack.peek().n] < F[A[i]]) {
                Item item = stack.pop();
                ret[item.index] = A[i];
            }
            stack.add(new Item(A[i], i));
        }

        printResult(ret);
    }

    private static void printResult(int[] ret) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ret[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        ret = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            F[A[i]]++;
            ret[i] = -1;
        }
    }

    private static final class Item {
        int n, index;

        Item(int n, int index) {
            this.n = n;
            this.index = index;
        }
    }
}
