package programmers;

import java.util.HashMap;
import java.util.HashSet;

public class prob86048 {
    public static void main(String[] args) {
        int[][] enter = { { 1, 3, 2 }, { 1, 4, 2, 3 }, { 3, 2, 1 }, { 3, 2, 1 }, { 1, 4, 2, 3 } };
        int[][] leave = { { 1, 2, 3 }, { 2, 1, 3, 4 }, { 2, 1, 3 }, { 1, 3, 2 }, { 2, 1, 4, 3 } };

        for (int i = 0; i < leave.length; i++) {
            for (int e : solution(enter[i], leave[i])) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    public static int[] solution(int[] enter, int[] leave) {
        HashSet<Integer> room = new HashSet<>();
        HashMap<Integer, Integer> result = new HashMap<>();
        int length = leave.length;
        for (int i = 0; i < length; i++) {
            result.put(i + 1, 0);
        }
        int l = 0, e = 0;
        while (l < length) {
            while (e < length && !room.contains(leave[l])) {
                room.add(enter[e++]);
            }
            room.remove(leave[l]);
            result.put(leave[l], result.get(leave[l]) + room.size());
            for (int person : room) {
                result.put(person, result.get(person) + 1);
            }
            l++;
        }

        int[] ret = new int[leave.length];
        for (int i = 1; i <= leave.length; i++) {
            ret[i - 1] = result.get(i);
        }
        return ret;
    }
}
