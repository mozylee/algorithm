# 출처: https://www.acmicpc.net/problem/1978
# 문제: 소수 찾기


import sys

_ = sys.stdin.readline()
nums = list(map(int, sys.stdin.readline().split()))
result = 0
for num in nums:
    print(num)
    if num < 2:
        continue
    if num < 4:
        result += 1
        continue
    if num % 2 == 0:
        continue

    is_prime = True
    print('i:', *list(range(3, int(num ** (1 / 2)) + 1, 2)))
    for i in range(3, int(num ** (1 / 2)) + 1, 2):
        if num % i == 0:
            is_prime = False
            break
    if is_prime:
        result += 1

print(result)
