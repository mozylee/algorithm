package programmers;

public class prob43165 {
    static int result, max, N;
    static int[] nums;
    static boolean[] isPlus;

    public static int solution(int[] numbers, int target) {
        N = target;
        nums = numbers;
        max = numbers.length;
        isPlus = new boolean[max];
        return dfs(0);
    }

    private static int dfs(int count) {
        if (count == max) {
            int evaluatedNumber = calculate();
            print();
            System.out.println(" = " + evaluatedNumber);
            return evaluatedNumber == N ? 1 : 0;
        }
        isPlus[count] = true;
        int plus = dfs(count + 1);
        isPlus[count] = false;
        int minus = dfs(count + 1);
        return plus + minus;
    }

    private static int calculate() {
        int sum = 0;
        for (int i = 0; i < max; i++) {
            sum += isPlus[i] ? nums[i] : -nums[i];
        }
        return sum;
    }

    private static void print() {
        for (int i = 0; i < max; i++) {
            System.out.printf("%c%d ", isPlus[i] ? '+' : '-', nums[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 1, 1, 1, 1, 1 }, 3));
    }
}
