# 출처: https://www.acmicpc.net/problem/1748
# 문제: 수 이어 쓰기 1


from math import log10

n = int(input())
log_n = int(log10(n))
result = 0
for i in range(log_n):
    result += (i + 1) * 9 * pow(10, i)
result += (log_n + 1) * (n - 10 ** log_n + 1)
print(result)
