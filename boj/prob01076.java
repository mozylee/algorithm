package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class prob01076 {
    static final Map<String, Integer> value = new HashMap<String, Integer>();
    static final Map<String, Integer> multiple = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;
        result += 10 * value.get(br.readLine());
        result += value.get(br.readLine());
        result *= multiple.get(br.readLine());
        System.out.println(result);
    }

    public static void init() {
        String[] colors = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white" };
        for (int i = 0; i < colors.length; i++) {
            value.put(colors[i], i);
            multiple.put(colors[i], (int) Math.pow(10, i));
        }
    }
}