# 출처: https://www.acmicpc.net/problem/11653
# 문제: 소인수분해


def get_primes(n):
    array = [True] * (n + 1)
    for i in range(2, int(n ** (1 / 2)) + 1):
        if array[i]:
            j = 2
            while i * j <= n:
                array[i * j] = False
                j += 1
    return [i for i in range(2, n + 1) if array[i]]


n = int(input())
primes = get_primes(n)
for prime in primes:
    while n % prime == 0:
        n //= prime
        print(prime)
