# 출처: https://www.acmicpc.net/problem/2292
# 문제: 벌집

from bisect import bisect_left

n = int(input())
honeycomb = [1]
i = 1
while honeycomb[-1] <= n:
    honeycomb.append(honeycomb[-1] + 6 * i)
    i += 1

print(honeycomb)
print(bisect_left(honeycomb, n) + 1)
