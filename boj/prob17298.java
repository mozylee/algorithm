package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class prob17298 {
    private static int N;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = input();

        int[] ret = new int[N];
        Arrays.fill(ret, -1);
        Stack<Item> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek().n < n) {
                Item item = stack.pop();
                ret[item.index] = n;
            }
            stack.add(new Item(n, i));
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

    private static StringTokenizer input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        return new StringTokenizer(br.readLine());
    }

    private static final class Item {
        int n, index;

        Item(int n, int index) {
            this.n = n;
            this.index = index;
        }
    }
}
