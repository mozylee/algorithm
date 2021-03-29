# 출처: https://www.acmicpc.net/problem/10824
# 문제: 네 수

a, b, c, d = input().split()
print(eval(a + b + '+' + c + d))  # 대신 int(a + b) + int(c + d)
