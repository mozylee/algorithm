# 출처: https://www.acmicpc.net/problem/2581
# 문제: 소수


m = int(input())
n = int(input())
primes = []

for num in range(m, n + 1):
    if num < 2:
        continue
    if 1 < num < 4:
        primes.append(num)
        continue
    if num % 2 == 0:
        continue
    is_prime = True
    for i in range(3, int(num ** 0.5) + 1, 2):
        if num % i == 0:
            is_prime = False
            break
    if is_prime:
        primes.append(num)

if not primes:
    print(-1)
    exit(0)
print(sum(primes))
print(primes[0])
