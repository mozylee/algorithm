package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prob01379 {
    private static int N;

    private static PriorityQueue<ClassRoom> classRooms = new PriorityQueue<>();
    private static PriorityQueue<Class> classes = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        input();

        int[] schedules = new int[N + 1];
        int count = 1;

        while (!classes.isEmpty()) {
            Class now = classes.poll();
            if (classRooms.peek().lastTime > now.start) {
                classRooms.add(new ClassRoom(++count, 0));
            }

            ClassRoom classRoom = classRooms.poll();
            classRoom.lastTime = now.end;
            schedules[now.n] = classRoom.n;
            classRooms.add(classRoom);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(classRooms.size());
        for (int i = 1; i <= N; i++) {
            sb.append("\n").append(schedules[i]);
        }
        System.out.print(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        classRooms.add(new ClassRoom(1, 0));

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            classes.add(new Class(n, start, end));
        }
    }

    private static final class ClassRoom implements Comparable<ClassRoom> {
        int n;
        int lastTime;

        ClassRoom(int n, int lastTime) {
            this.n = n;
            this.lastTime = lastTime;
        }

        @Override
        public int compareTo(ClassRoom cR) {
            return Integer.compare(this.lastTime, cR.lastTime);
        }

        @Override
        public String toString() {
            return "(" + n + " : " + lastTime + ")";
        }
    }

    private static final class Class implements Comparable<Class> {
        int n;
        int start;
        int end;

        Class(int n, int start, int end) {
            this.n = n;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Class c) {
            return this.start == c.start ? this.end - c.end : this.start - c.start;
        }

        @Override
        public String toString() {
            return "(" + n + ":" + start + "," + end + ")";
        }
    }
}
