# 출처: https://www.acmicpc.net/problem/17389
# 문제: 보너스 점수


_ = input()

bonus = 0
result = 0
for i, ox in enumerate(input()):
    if ox == "O":
        result += i + 1 + bonus
        bonus += 1
    else:
        bonus = 0

print(result)
