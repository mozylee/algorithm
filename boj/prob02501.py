# 출처: https://www.acmicpc.net/problem/2501
# 문제: 약수 구하기


n, k = map(int, input().split())
count = 0
for i in range(1, n+1):
    if n % i == 0:
        count += 1
        if count == k:
            print(i)
            exit(0)
print(0)
