package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class prob10421 {
    private static int N, K;
    private static int[] lengthes;
    private static HashSet<Integer> numSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        input();

        ArrayList<Integer> s1 = getNumbers(lengthes[0]);
        ArrayList<Integer> s2 = getNumbers(lengthes[1]);
        int count = 0;
        for (int i : s1) {
            for (int j : s2) {
                boolean flag = true;
                if (!isRightLength(i * j, lengthes[N - 1]) || !isRightNumber(i * j)) {
                    continue;
                }
                for (int level = 0; level <= lengthes[1]; level++) {
                    int k = j % 10;
                    j /= 10;
                    if (!isRightLength(i * k, lengthes[2 + level]) || !isRightNumber(i * k)) {
                        flag = false;
                        break;
                    }
                }
                count += flag ? 1 : 0;
            }
        }
        System.out.println(count);

    }

    private static boolean isRightNumber(int i) {
        while (i > 0) {
            if (!numSet.contains(i % 10))
                return false;
            i /= 10;
        }
        return true;
    }

    private static ArrayList<Integer> getNumbers(int i) {
        ArrayList<Integer> ret = new ArrayList<>();
        dfs(0, i, ret);
        return ret;
    }

    private static void dfs(int num, int length, ArrayList<Integer> ret) {
        if (isRightLength(num, length)) {
            ret.add(num);
            return;
        }
        num *= 10;
        for (int i : numSet) {
            dfs(num + i, length, ret);
        }
    }

    private static boolean isRightLength(int num, int length) {
        return (int) Math.log10(num) == length;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.valueOf(br.readLine());
        st = new StringTokenizer(br.readLine());
        lengthes = new int[N];
        for (int i = 0; i < N; i++) {
            lengthes[i] = Integer.valueOf(st.nextToken()) - 1;
        }
        K = Integer.valueOf(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            numSet.add(Integer.valueOf(st.nextToken()));
        }
    }
}
