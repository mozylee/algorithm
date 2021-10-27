package boj;

public class prob15550 {
    public static void main(String[] args) {
        float a = Float.valueOf("1000000000000");
        long b = Long.valueOf("1000000000000");
        double c = Double.valueOf("1000000000000");

        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a == c);
    }
}
