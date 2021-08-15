package boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob01931 {
    static int N;
    static Meeting[] meetings;

    public static void main(String[] args) {
        input();
        int count = 0;
        int end = 0;
        for (Meeting meeting : meetings) {
            if (meeting.start >= end) {
                end = meeting.end;
                count++;
            }
        }
        System.out.println(count);
    }

    static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            meetings = new Meeting[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                meetings[i] = new Meeting(start, end);
            }
            Arrays.sort(meetings);
        } catch (Exception e) {
        }
    }

    static class Meeting implements Comparable<Meeting> {
        int start, end;

        Meeting(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Meeting m) {
            if (this.end == m.end)
                return this.start - m.start;
            return this.end - m.end;
        }

        @Override
        public String toString() {
            return "(" + start + " ~ " + end + ")";
        }
    }
}