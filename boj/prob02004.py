# 출처: https://www.acmicpc.net/problem/2004
# 문제: 조합 0의 개수


n, m = map(int, input().split())


def count_n(x, base):
    count = 0
    while x:
        x //= base
        count += x
    return count


count_5 = count_n(n, 5) - count_n(m, 5) - count_n(n - m, 5)
count_2 = count_n(n, 2) - count_n(m, 2) - count_n(n - m, 2)

print(min(count_2, count_5))
