# 출처: https://www.acmicpc.net/problem/6416
# 문제: 트리인가?


def get_comb_case(n, k, sum_stones):
    if n < k:
        return 0
    result = 1

    for i in range(k):
        result *= n - i
        result /= sum_stones - i
    return result


import sys

read = sys.stdin.readline

m = int(read())
stones = list(map(int, read().split()))
sum_stones = sum(stones)
k = int(read())

cases = sum(get_comb_case(stone, k, sum_stones) for stone in stones)
print(cases)

