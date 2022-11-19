import sys


read = sys.stdin.readline


def get_primes():
    primes = [True]*200

    for i in range(2, 200):
        if not primes[i]:
            continue

        j = 2
        while i*j < 200:
            primes[i*j] = False
            j += 1

    return [i for i in range(2, 200) if primes[i]]


primes = get_primes()

N = int(read())

for i in range(len(primes)-1):
    if primes[i] * primes[i+1] > N:
        print(primes[i] * primes[i+1])
        break
