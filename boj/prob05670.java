package boj;

import java.io.*;
import java.util.HashMap;

public class prob05670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            // 테스트용
            if (input.equals(""))
                break;
            int amount = Integer.parseInt(input);
            String[] inputs = new String[amount];
            Trie trie = new Trie();
            for (int i = 0; i < amount; i++) {
                inputs[i] = br.readLine().trim();
                trie.insert(inputs[i]);
            }
            bw.write(String.format("%.2f\n", trie.countTrie() / 100));
        }
        bw.flush();
        bw.close();
    }

    static class Trie {
        private TrieNode rootNode;

        Trie() {
            rootNode = new TrieNode();
        }

        void insert(String word) {
            TrieNode thisNode = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            thisNode.setIsLastChar(true);
        }

        double countTrie() {
            int amount = 0;
            for (TrieNode childNode : rootNode.getChildNodes().values()) {
                amount += recursive(childNode, 1);
            }
            return (double) amount;
        }

        int recursive(TrieNode thisNode, int level) {
            if (thisNode.getChildNodes().size() == 0) {
                return level;
            }
            int amount = 0;
            if (thisNode.getChildNodes().size() > 1 || thisNode.isLastChar()) {
                if (thisNode.isLastChar()) {
                    amount += level;
                }
                level++;
            }
            for (Character childNode : thisNode.getChildNodes().keySet()) {
                amount += recursive(thisNode.getChildNodes().get(childNode), level);
            }
            return amount;
        }
    }

    static class TrieNode {
        private HashMap<Character, TrieNode> childNode = new HashMap<>();
        private boolean isLastChar;

        boolean isLastChar() {
            return this.isLastChar;
        }

        HashMap<Character, TrieNode> getChildNodes() {
            return this.childNode;
        }

        void setIsLastChar(boolean isLastChar) {
            this.isLastChar = isLastChar;
        }
    }
}
