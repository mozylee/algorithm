package boj;

public class prob15549 {
    public static boolean isAnswer(int x) {
        if (x != 0 && x == -x) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isAnswer(Integer.MIN_VALUE));
        // abs(Integer.MIN_VALUE) > abs(Integer.MAX_VALUE)
        // -Integer.MIN_VALUE : OVERFLOW!!
    }
}
