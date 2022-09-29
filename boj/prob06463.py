import sys


factorials = [1]*10001

for i in range(2, 10001):
    factorials[i] = factorials[i-1]*i

    while factorials[i] % 10 == 0:
        factorials[i] //= 10

print(*(f"{int(i):5} -> {factorials[int(i)]%10}" for i in sys.stdin.readlines()),
      sep="\n")
