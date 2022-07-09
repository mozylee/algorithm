package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob11000 {
    private static int N;
    private static ArrayList<Class> classes;

    public static void main(String[] args) throws IOException {
        input();

        PriorityQueue<Integer> classRooms = new PriorityQueue<>();
        classRooms.add(0);
        for (Class now : classes) {
            if (classRooms.peek() > now.start) {
                classRooms.add(0);
            }
            classRooms.poll();
            classRooms.add(now.end);
        }

        System.out.println(classRooms.size());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        classes = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            classes.add(new Class(start, end));
        }

        classes.sort(new Comparator<Class>() {
            @Override
            public int compare(Class c1, Class c2) {
                return c1.start == c2.start ? Integer.compare(c1.end, c2.end) : Integer.compare(c1.start, c2.start);
            }
        });
    }

    private static final class Class {
        int start, end;

        Class(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start + "," + end + ")";
        }
    }
}
