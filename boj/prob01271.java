package boj;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class prob01271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());
        BigInteger[] result = n.divideAndRemainder(m);
        System.out.println(result[0] + "\n" + result[1]);
    }
}
