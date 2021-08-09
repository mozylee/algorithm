package programmers;

public class prob83201 {
    static String solution(int[][] scores) {
        int[][] copy = new int[scores.length][scores.length];
        for (int i = 0; i < copy.length; i++)
            for (int j = 0; j < copy.length; j++)
                copy[j][i] = scores[i][j];

        String answer = "";
        for (int i = 0; i < copy.length; i++)
            answer += getGrade(i, copy[i]);
        return answer;
    }

    static String getGrade(int index, int[] scores) {
        double score = getResult(scores[index], scores);
        if (score >= 90)
            return "A";
        else if (score >= 80)
            return "B";
        else if (score >= 70)
            return "C";
        else if (score >= 50)
            return "D";
        else
            return "F";
    }

    static double getResult(int score, int[] scores) {
        int sum = 0, count = 0, max = -1, min = 101;
        int length = scores.length;

        for (int i = 0; i < scores.length; i++) {
            max = Math.max(max, scores[i]);
            min = Math.min(min, scores[i]);
            sum += scores[i];
            if (scores[i] == score)
                count++;
        }
        if ((score == max || score == min) && count == 1) {
            sum -= score;
            length--;
        }
        return sum / length;
    }

    public static void main(String[] args) {
        int[][] test = { { 100, 90, 98, 88, 65 }, { 50, 45, 99, 85, 77 }, { 47, 88, 95, 80, 67 },
                { 61, 57, 100, 80, 65 }, { 24, 90, 94, 75, 65 } };
        System.out.println(solution(test));
    }
}
