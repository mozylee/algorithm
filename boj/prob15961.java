package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob15961 {
    private static int N, d, k, c;
    private static int[] belts;

    public static void main(String[] args) throws IOException {
        input();
        int[] sushies = new int[d + 1];
        int left = 0, right = 0;
        int count = 0;
        while (right < k) {
            if (++sushies[belts[right++]] == 1) {
                count++;
            }
        }
        int max = sushies[c] > 0 ? count : count + 1;
        right--;
        
        while (left < N) {
            int newSushi = belts[++right % N];
            if (++sushies[newSushi] == 1) {
                count++;
            }
            if (Math.abs(right - left) >= k) {
                if (--sushies[belts[left++]] == 0) {
                    count--;
                }
            }
            max = Math.max(max, (sushies[c] > 0 ? count : count + 1));
        }
        System.out.println(max);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        d = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());
        c = Integer.valueOf(st.nextToken());
        belts = new int[N];
        for (int i = 0; i < N; i++) {
            belts[i] = Integer.valueOf(br.readLine());
        }
    }
}
