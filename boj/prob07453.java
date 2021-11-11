package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class prob07453 {
    private static int N;
    private static final int SIZE = 4;
    private static int[][] nums;

    public static void main(String[] args) throws IOException {
        input();
        HashMap<Integer, Integer> sumMap = getSumSet(nums[2], nums[3]);
        long caseCount = 0;
        for (int i : nums[0]) {
            for (int j : nums[1]) {
                caseCount += sumMap.containsKey(-(i + j)) ? sumMap.get(-(i + j)) : 0;
            }
        }
        System.out.println(caseCount);
    }

    private static HashMap<Integer, Integer> getSumSet(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> ret = new HashMap<>();
        for (int i : arr1) {
            for (int j : arr2) {
                ret.compute(i + j, (k, v) -> ret.containsKey(k) ? v + 1 : 1);
            }
        }
        return ret;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        nums = new int[SIZE][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                nums[j][i] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
