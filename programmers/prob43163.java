package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class prob43163 {
    private static HashMap<String, HashSet<String>> graph = new HashMap<>();
    private static int length;

    public static int solution(String begin, String target, String[] words) {
        length = target.length();
        if (!makeGraph(begin, target, words)) {
            return 0;
        }

        return bfs(begin, target);
    }

    private static int bfs(String begin, String target) {
        HashSet<String> visited = new HashSet<>();
        visited.add(begin);

        Queue<Trial> queue = new LinkedList<>();
        queue.add(new Trial(begin, 0));

        while (!queue.isEmpty()) {
            Trial now = queue.poll();

            for (String next : graph.get(now.word)) {
                if (visited.contains(next)) {
                    continue;
                }
                visited.add(next);
                if (next.equals(target)) {
                    return now.count + 1;
                }
                queue.add(new Trial(next, now.count + 1));
            }
        }

        return 0;
    }

    private static boolean makeGraph(String begin, String target, String[] words) {
        boolean flag = false;

        for (String word : words) {
            if (word.equals(target)) {
                flag = true;
            }
            graph.put(word, new HashSet<>());
        }

        if (!graph.containsKey(begin)) {
            graph.put(begin, new HashSet<>());
            words = Arrays.copyOf(words, words.length + 1);
            words[words.length - 1] = begin;
        }

        if (!flag) {
            return flag;
        }

        for (String from : words) {
            for (String to : words) {
                if (from.equals(to) || graph.get(to).contains(from)) {
                    continue;
                }
                if (getCharDiff(from, to) == 1) {
                    graph.get(from).add(to);
                    graph.get(to).add(from);
                }
            }
        }
        return flag;
    }

    private static int getCharDiff(String from, String to) {
        int diff = 0;
        for (int i = 0; i < length; i++) {
            diff += from.charAt(i) != to.charAt(i) ? 1 : 0;
        }
        return diff;
    }

    private static final class Trial {
        String word;
        int count;

        Trial(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public String toString() {
            return word + "," + count;
        }
    }

    public static void main(String[] args) {
        String[] begin = { "hit", "hit" };
        String[] target = { "cog", "cog" };
        String[][] words = { { "hot", "dot", "dog", "lot", "log", "cog" }, { "hot", "dot", "dog", "lot", "log" } };

        // 4
        // 0
        for (int i = 0; i < words.length; i++) {
            System.out.println(solution(begin[i], target[i], words[i]));
            graph.clear();
        }
    }
}
