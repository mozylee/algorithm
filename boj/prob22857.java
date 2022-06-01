package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob22857 {
    private static int S, K;
    private static int[] sequence;

    public static void main(String[] args) throws IOException {
        input();

        int left = 0, right = 0;
        int oddCount = sequence[0] % 2 == 0 ? 0 : 1;
        int evenCount = 1 - oddCount;
        int max = evenCount;
        while (left <= right && right < S - 1) {
            if (sequence[++right] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
            max = Math.max(max, evenCount);

            if (oddCount > K) {
                if (sequence[left++] % 2 == 0) {
                    evenCount--;
                } else {
                    oddCount--;
                }
                continue;
            }
        }
        System.out.println(max);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sequence = new int[S];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }
}
