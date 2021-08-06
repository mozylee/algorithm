package programmers;

import java.util.HashSet;

public class prob12981 {
    public static int[] solution(int n, String[] words) {
        int before = 0;
        HashSet<String> hs = new HashSet<>();
        hs.add(words[before]);
        for (int i = 1; i < words.length; i++) {
            if (hs.contains(words[i]) || isOkay(words[before++], words[i]))
                return new int[] { (i % n) + 1, (i / n) + 1 };
            hs.add(words[i]);
        }
        return new int[] { 0, 0 };
    }

    public static boolean isOkay(String before, String now) {
        return before.charAt(before.length() - 1) != now.charAt(0);
    }

    // Test용 main
    public static void main(String[] args) {
        int[] result = solution(3,
                new String[] { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" });
        System.out.println(result[0] + " " + result[1]);
    }
}
