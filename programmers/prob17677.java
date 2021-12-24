package programmers;

import java.util.HashMap;

public class prob17677 {
    private static final int A = 65;

    public static int solution(String str1, String str2) {
        HashMap<Integer, Integer> s1 = getTokens(str1.toUpperCase());
        HashMap<Integer, Integer> s2 = getTokens(str2.toUpperCase());
        return (int) (getJaccad(s1, s2) * 65536);
    }

    private static double getJaccad(HashMap<Integer, Integer> s1, HashMap<Integer, Integer> s2) {
        if (s1.isEmpty() && s2.isEmpty())
            return 1;
        return (double) intersect(s1, s2) / union(s1, s2);
    }

    private static HashMap<Integer, Integer> getTokens(String s) {
        HashMap<Integer, Integer> tokens = new HashMap<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (!isAlpha(s.charAt(i)) || !isAlpha(s.charAt(i + 1)))
                continue;
            tokens.compute(makeToken(s, i), (k, v) -> v == null ? 1 : v + 1);
        }
        return tokens;
    }

    private static boolean isAlpha(char c) {
        return A <= c && c < A + 26;
    }

    private static int makeToken(String s, int i) {
        return s.charAt(i) * 100 + s.charAt(i + 1);
    }

    private static int intersect(HashMap<Integer, Integer> s1, HashMap<Integer, Integer> s2) {
        int intersection = 0;
        for (int key : s1.keySet())
            intersection += s2.containsKey(key) ? Math.min(s1.get(key), s2.get(key)) : 0;
        return intersection;
    }

    private static int union(HashMap<Integer, Integer> s1, HashMap<Integer, Integer> s2) {
        int union = 0;
        for (int key : s1.keySet())
            union += s2.containsKey(key) ? Math.max(s1.get(key), s2.get(key)) : s1.get(key);
        for (int key : s2.keySet())
            union += !s1.containsKey(key) ? s2.get(key) : 0;
        return union;
    }

    public static void main(String args[]) {
        String[] s1 = { "french", "shake hands", "AAAA12", "e=m*c^2" };
        String[] s2 = { "FRANCE", "handshake", "aa1+aa2", "E=M*C^2", };
        for (int i = 0; i < s2.length; i++) {
            System.out.println(solution(s1[i], s2[i]));
        }
        // 16384
        // 65536
        // 43690
        // 65536
    }
}
