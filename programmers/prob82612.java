package programmers;

class prob82612 {
    public long solution(int price, int money, int count) {
        return Math.max((long) price * count * (count + 1) / 2 - money, 0L);
    }
}
