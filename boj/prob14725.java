package boj;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class prob14725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            String[] inputs = new String[K];
            for (int j = 0; j < K; j++) {
                inputs[j] = st.nextToken();
            }
            trie.insert(inputs);
        }
        bw.write(trie.triversal());
        bw.flush();
        bw.close();
    }

    static class Trie {
        private TrieNode rootNode;

        Trie() {
            rootNode = new TrieNode();
        }

        void insert(String[] words) {
            TrieNode thisNode = this.rootNode;
            for (String word : words) {
                thisNode = thisNode.getChildNodes().computeIfAbsent(word, c -> new TrieNode());
            }
        }

        String triversal() {
            return recursive(rootNode, 0);
        }

        String recursive(TrieNode thisNode, int level) {
            if (thisNode.getChildNodes().size() == 0) {
                return "";
            }
            String result = "";
            String bars = getBars(level);
            Object[] keySet = thisNode.getChildNodes().keySet().toArray();
            Arrays.sort(keySet);
            for (Object childNode : keySet) {
                result += bars + childNode + "\n";
                result += recursive(thisNode.getChildNodes().get(childNode), level + 1);
            }
            return result;
        }

        String getBars(int level) {
            String result = "";
            for (int i = 0; i < level; i++) {
                result += "--";
            }
            return result;
        }
    }

    static class TrieNode {
        private HashMap<String, TrieNode> childNode = new HashMap<>();

        HashMap<String, TrieNode> getChildNodes() {
            return this.childNode;
        }
    }
}