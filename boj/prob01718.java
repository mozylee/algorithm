package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob01718 {
    static final int A = 'a', SIZE = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String plain = br.readLine();
        char[] key = br.readLine().toCharArray();
        char[] cipher = new char[plain.length()];
        for (int i = 0; i < cipher.length; i++) {
            cipher[i] = getCipher(plain.charAt(i), key[i % key.length], i);
        }
        System.out.println(String.valueOf(cipher));
    }

    private static char getCipher(char plain, char key, int i) {
        return plain != ' ' ? getCipherChar(plain, key) : plain;
    }

    private static char getCipherChar(char plain, char key) {
        return (char) ((plain - key + SIZE - 1) % SIZE + A);
    }
}
