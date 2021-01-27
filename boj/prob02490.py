# 출처: https://www.acmicpc.net/problem/2490
# 문제: 윷놀이

for _ in range(3):
    print(["D", "C", "B", "A", "E"][sum(map(int, input().split()))])

