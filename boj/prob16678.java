package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class prob16678 {
    private static int N;
    private static int[] members;

    public static void main(String[] args) throws IOException {
        input();

        long hackers = 0;
        int before = 0;
        for (int i = 0; i < N; i++) {
            if (members[i] <= before) {
                continue;
            }

            hackers += members[i] - ++before;
            members[i] = before;
        }
        System.out.println(hackers);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        members = new int[N];
        for (int i = 0; i < N; i++) {
            members[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(members);
    }
}
