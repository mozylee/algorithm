package boj;

import java.io.*;
import java.util.StringTokenizer;

// 푼거 같은데... 자바로 푼 사람이 없네... 시간 초과 ㅠㅠㅠㅠ
public class prob19585 {
    static final String YES = "Yes\n", NO = "No\n";

    public static void main(String[] args) throws IOException {
        test();
    }

    static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        Trie Colors = new Trie();
        Trie Nicknames = new Trie();
        for (int i = 0; i < C; i++) {
            Colors.insert(br.readLine().trim());
        }
        for (int i = 0; i < N; i++) {
            Nicknames.insert(new StringBuilder(br.readLine()).reverse().toString());
        }
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String team = br.readLine();
            String reversedTeam = new StringBuilder(team).reverse().toString();
            int colorIndex = Colors.find(team) + 1;
            int nicknameIndex = Nicknames.find(reversedTeam) + 1;
            bw.write(colorIndex + nicknameIndex == team.length() ? YES : NO);
        }
        bw.flush();
        bw.close();
    }

    static class Trie {
        private TrieNode rootNode;
        static final int SIZE = 26;

        Trie() {
            rootNode = new TrieNode();
        }

        void insert(String word) {
            TrieNode thisNode = this.rootNode;
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                int num = charToInt(c);
                if (thisNode.childNode[num] == null) {
                    thisNode.childNode[num] = new TrieNode();
                }
                thisNode = thisNode.childNode[num];
            }
            thisNode.setIsLastChar(true);
        }

        int find(String word) {
            int length = word.length();
            TrieNode thisNode = this.rootNode;
            for (int i = 0; i < length; i++) {
                int num = charToInt(word.charAt(i));
                TrieNode child = thisNode.childNode[num];
                if (child == null) {
                    return -1;
                }
                if (child.isLastChar()) {
                    return i;
                }
                thisNode = child;
            }
            return length;
        }

        int charToInt(char c) {
            return c - 'a';
        }

        private static class TrieNode {
            private TrieNode[] childNode = new TrieNode[SIZE];
            private boolean isLastChar;

            boolean isLastChar() {
                return this.isLastChar;
            }

            void setIsLastChar(boolean isLastChar) {
                this.isLastChar = isLastChar;
            }
        }
    }
}