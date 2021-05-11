# 출처: https://www.acmicpc.net/problem/1668
# 문제: 트로피 진열


trophies = [int(input()) for _ in range(int(input()))]
left, right = 1, 1
min_left, min_right = trophies[0], trophies[-1]

for i in range(1, len(trophies)):
    if trophies[i] > min_left:
        min_left = trophies[i]
        left += 1
    if trophies[-(i + 1)] > min_right:
        min_right = trophies[-(i + 1)]
        right += 1

print(left)
print(right)
