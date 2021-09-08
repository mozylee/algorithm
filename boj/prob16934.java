package boj;

import java.io.*;
import java.util.HashMap;

public class prob16934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Trie trie = new Trie();
        trie.insert("1");
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String word = br.readLine().trim();
            bw.write(trie.insert(word) + "\n");
        }
        bw.flush();
        bw.close();
    }

    static class Trie {
        private TrieNode rootNode;

        Trie() {
            rootNode = new TrieNode();
        }

        String insert(String word) {
            TrieNode thisNode = this.rootNode;
            String nickname = "";
            for (int i = 0; i < word.length(); i++) {
                if (thisNode.getChildNodes().size() > 0 || thisNode.getNicknameNumber() > 0) {
                    nickname += word.charAt(i);
                }
                thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            thisNode.setIsNickname();
            if (nickname.equals(word) && thisNode.getNicknameNumber() > 1) {
                nickname += thisNode.getNicknameNumber();
            }
            return nickname;
        }
    }

    static class TrieNode {
        private HashMap<Character, TrieNode> childNode = new HashMap<>();
        private int nicknames;

        int getNicknameNumber() {
            return this.nicknames;
        }

        HashMap<Character, TrieNode> getChildNodes() {
            return this.childNode;
        }

        void setIsNickname() {
            this.nicknames++;
        }
    }
}
