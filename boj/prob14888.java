package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob14888 {
    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[] nums, operators = new int[4];
    static int[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        isSelected = new int[N - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(max + "\n" + min);
    }

    public static void dfs(int count) {
        if (count == N - 1) {
            int result = getResult();
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                isSelected[count] = i;
                dfs(count + 1);
                operators[i]++;
            }
        }
    }

    public static int getResult() {
        int result = calculate(nums[0], nums[1], isSelected[0]);
        for (int i = 1; i < N - 1; i++) {
            result = calculate(result, nums[i + 1], isSelected[i]);
        }
        return result;
    }

    public static int calculate(int a, int b, int instructor) {
        switch (instructor) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            case 3:
                return a / b;
        }
        return 0;
    }
}
