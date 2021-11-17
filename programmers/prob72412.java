package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class prob72412 {
    static HashMap<String, ArrayList<String>> keyMap;

    public static int[] solution(String[] info, String[] query) {
        HashMap<String, ArrayList<Integer>> infoMap = parseInfo(info);
        Query[] queries = parseQueries(query);
        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            Query q = queries[i];
            ans[i] = getAmountOfCandidates(q.score, infoMap.get(q.key));
        }
        return ans;
    }

    private static int getAmountOfCandidates(int score, ArrayList<Integer> scores) {
        int left = 0, right = scores.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) < score) {
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
        return scores.size() - left;
    }

    private static Query[] parseQueries(String[] query) {
        Query[] ret = new Query[query.length];
        for (int i = 0; i < ret.length; i++)
            ret[i] = parseQuery(query[i]);
        return ret;
    }

    private static Query parseQuery(String query) {
        String[] tokens = query.split(" ");
        String key = "";
        for (int i = 0; i < 4; i++)
            key += tokens[i * 2];
        return new Query(key, Integer.valueOf(tokens[7]));
    }

    private static HashMap<String, ArrayList<Integer>> parseInfo(String[] info) {
        HashMap<String, ArrayList<Integer>> ret = initMap();
        for (String i : info) {
            String[] token = i.split(" ");
            String key = getKey(token);
            int score = Integer.valueOf(token[4]);
            updateInfo(ret, key, score);
        }
        for (String k : ret.keySet())
            ret.get(k).sort(null);
        return ret;
    }

    private static HashMap<String, ArrayList<Integer>> initMap() {
        HashMap<String, ArrayList<Integer>> ret = new HashMap<>();
        keyMap = new HashMap<>();
        String[] languages = { "cpp", "java", "python" };
        String[] jobs = { "backend", "frontend" };
        String[] careers = { "junior", "senior" };
        String[] soulfoods = { "chicken", "pizza" };
        for (String l : languages) {
            for (String j : jobs) {
                for (String c : careers) {
                    for (String s : soulfoods) {
                        String key = l + j + c + s;
                        keyMap.put(key, new ArrayList<>());
                        for (String k : getWildKeys(l, j, c, s)) {
                            ret.put(k, new ArrayList<>());
                            keyMap.get(key).add(k);
                        }
                    }
                }
            }
        }
        return ret;
    }

    private static String getKey(String[] token) {
        return token[0] + token[1] + token[2] + token[3];
    }

    private static void updateInfo(HashMap<String, ArrayList<Integer>> ret, String key, int score) {
        for (String k : keyMap.get(key))
            ret.get(k).add(score);
    }

    private static ArrayList<String> getWildKeys(String l, String j, String c, String s) {
        final String WILDCARD = "-";
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (int k = 0; k < 2; k++) {
                for (int m = 0; m < 2; m++) {
                    for (int n = 0; n < 2; n++) {
                        ret.add((i == 0 ? l : WILDCARD)
                                + (k == 0 ? j : WILDCARD)
                                + (m == 0 ? c : WILDCARD)
                                + (n == 0 ? s : WILDCARD));
                    }
                }
            }
        }
        return ret;
    }

    static class Query {
        String key;
        int score;

        Query(String key, int score) {
            this.key = key;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        String[] info = new String[] { "java backend junior pizza 150", "python frontend senior chicken 210",
                "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
                "python backend senior chicken 50" };
        String[] query = new String[] { "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
        System.out.println(Arrays.toString(solution(info, query)));
    }
}
