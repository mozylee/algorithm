package programmers;

public class prob12980 {
    public static int solution(int n) {
        return Integer.bitCount(n);
    }
    // 또는 짝수일 때 /=2, 홀수일 때 -=1로도 가능 

    public static void main(String[] args) {
        int[] testCases = { 5, 6, 5000 };
        for (int i : testCases) {
            System.out.println(solution(i));
        }
        // 2
        // 2
        // 5
    }
}