# 출처: https://www.acmicpc.net/problem/2869
# 문제: 달팽이는 올라가고 싶다

# x를 올라가는데 걸리는 날로 두면,
# v <= a * x - b * (x - 1)
# v <= (a - b) * x + b
# v - b <= (a - b) * x
# x >= (v - b) / (a - b)


a, b, v = map(int, input().split())

# 대충 Math.ceil import 하기 귀찮다는 뜻
print(-((v - b) // -(a - b)))
