package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob06549 {
    private static int N;
    private static int level, first;
    private static long max;
    private static int[] tree, histograms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (!line.equals("0")) {
            input(line);
            max = 0;
            tree = new int[1 << (level + 1)];
            tree[1] = init(1);
            divide(0, N - 1);
            sb.append(max).append("\n");
            line = br.readLine();
        }
        System.out.print(sb);
    }

    private static void input(String line) throws IOException {
        StringTokenizer st = new StringTokenizer(line);
        N = Integer.valueOf(st.nextToken());
        level = (int) Math.ceil(Math.log(N) / Math.log(2));
        first = 1 << (level);
        histograms = new int[first];
        Arrays.fill(histograms, Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            histograms[i] = Integer.valueOf(st.nextToken());
        }
    }

    private static int init(int node) {
        if (node >= first) {
            return node - first;
        }
        tree[node * 2] = init(node * 2);
        tree[node * 2 + 1] = init(node * 2 + 1);
        return histograms[tree[node * 2]] <= histograms[tree[node * 2 + 1]] ? tree[node * 2] : tree[node * 2 + 1];
    }

    private static void divide(int left, int right) {
        if (left > right) {
            return;
        }
        int minIndex = getMinIndex(left, right);
        max = Math.max(max, (long) (right - left + 1) * histograms[minIndex]);
        divide(left, minIndex - 1);
        divide(minIndex + 1, right);
    }

    private static int getMinIndex(int start, int end) {
        int left = start + first;
        int right = end + first;

        int minIndex = start;
        while (left <= right) {
            if (left % 2 == 1) {
                minIndex = histograms[minIndex] < histograms[tree[left]] ? minIndex : tree[left];
                left++;
            }
            if (right % 2 == 0) {
                minIndex = histograms[minIndex] < histograms[tree[right]] ? minIndex : tree[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return minIndex;
    }
}
