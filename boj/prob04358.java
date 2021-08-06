package boj;

import java.util.*;
import java.io.*;

public class prob04358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> hm = new HashMap<>();
        TreeSet<String> ts = new TreeSet<>();
        float total = 0;
        String tree;
        while ((tree = br.readLine()) != null) {
            if (!hm.containsKey(tree)) {
                ts.add(tree);
                hm.put(tree, 0);
            }
            int before = hm.get(tree);
            hm.put(tree, before + 1);
            total++;
        }

        for (String t : ts)
            bw.write(t + " " + String.format("%.4f", hm.get(t) / total * 100) + "\n");
        bw.flush();
        bw.close();
    }
}
