package programmers;

class Solution {
    public static void main(String[] args) {
        int[][] asd = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        System.out.println(solution(asd));
    }

    public static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) 
            for (int j = 0; j < triangle[i].length; j++)
                if (j == 0) 
                    dp[i][j] = triangle[i][j] + dp[i - 1][j];
                else if (j == i)
                    dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
                else 
                    dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < triangle.length; i++)
            max = Math.max(max, dp[triangle.length - 1][i]);
        return max;
    }
}