import sys


read = sys.stdin.readline


def get_primes(length: int) -> list:
    primes = []
    is_prime = [False, False]+[True]*(length-2)
    
    for i in range(2, length):
        if not is_prime[i]:
            continue

        primes.append(i)
        for j in range(i*2, length, i):
            is_prime[j] = False

    return primes


n = read()
A = list(map(int, read().split()))
print(sum(A[p-1] for p in get_primes(len(A)+1)))
