package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class prob01725 {
    private static int N;
    private static int level, first;
    private static int max;
    private static int[] tree;
    private static int[] histograms;

    public static void main(String[] args) throws IOException {
        input();
        tree = new int[1 << (level + 1)];
        tree[1] = init(1);
        divide(0, N - 1);
        System.out.println(max);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        level = (int) Math.ceil(Math.log(N) / Math.log(2));
        first = 1 << (level);
        histograms = new int[first];
        Arrays.fill(histograms, Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            histograms[i] = Integer.valueOf(br.readLine());
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
        max = Math.max(max, (right - left + 1) * histograms[minIndex]);
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
