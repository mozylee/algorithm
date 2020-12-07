# 출처: https://www.acmicpc.net/problem/2475
# 문제: 검증수

print(sum(map(lambda x: int(x) ** 2, input().split())) % 10)
