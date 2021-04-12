# 출처: https://www.acmicpc.net/problem/2839
# 문제: 설탕 배달


weight = int(input())
bags = 0
while weight >= 0:
    if weight % 5 == 0 or not weight:
        bags += weight // 5
        print(bags)
        exit(0)
    weight -= 3
    bags += 1
print(-1)
