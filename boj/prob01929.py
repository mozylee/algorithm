# 출처: https://www.acmicpc.net/problem/1929
# 문제: 소수 구하기

m, n = map(int, input().split())

result = 0
for num in range(m, n + 1):
    if num < 2:
        continue
    if num < 4:
        print(num)
        continue
    if num % 2 == 0:
        continue

    is_prime = True
    for i in range(3, int(num ** (1 / 2)) + 1, 2):
        if num % i == 0:
            is_prime = False
            break
    if is_prime:
        print(num)
