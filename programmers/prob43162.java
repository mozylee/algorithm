package programmers;

public class prob43162 {
    static boolean[] visited;
    static int[][] comp;

    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        comp = computers;
        int count = 0;
        for (int i = 0; i < n; i++) {
            computers[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int computer) {
        if (visited[computer]) {
            return;
        }
        visited[computer] = true;
        for (int i = 0; i < visited.length; i++) {
            if (comp[computer][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
        System.out.println(solution(3, new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } }));
    }
}
