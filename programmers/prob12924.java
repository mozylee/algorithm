package programmers;

public class prob12924 {
    public static int solution(int n) {
        if (n < 3)
            return 1;
        int answer = 1, left = 1, right = 2;
        int sum = left + right;
        while (right < n) {
            if (sum < n) {
                sum += ++right;
                continue;
            }
            if (sum == n)
                answer++;
            sum -= left++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
        System.out.println(solution(3));
    }
}