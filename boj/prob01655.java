package boj;

import java.io.*;
import java.util.ArrayList;

public class prob01655 {
    static ArrayList<Integer> sortedList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            insert(n, i);
            sb.append(sortedList.get(i / 2)).append('\n');
        }
        System.out.println(sb);
    }

    static void insert(int x, int size) {
        int s = 0;
        int e = size - 1;
        if (sortedList.isEmpty() || x > sortedList.get(e)) {
            sortedList.add(x);
            return;
        }
        if (x < sortedList.get(s)) {
            sortedList.add(0, x);
            return;
        }
        while (s <= e) {
            int mid = (s + e) / 2;
            if (sortedList.get(mid) >= x) {
                e = mid - 1;
            } else if (sortedList.get(mid) < x) {
                s = mid + 1;
            }
        }
        sortedList.add(s, x);
    }
}
