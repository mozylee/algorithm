import sys


sys.setrecursionlimit(10**7)

n, k = map(int, sys.stdin.readline().split())

dp = {}


def get_binomial(n: int, k: int) -> int:
    if (n, k) in dp:
        return dp[(n, k)]
    if n == k or k == 1:
        dp[(n, k)] = 1
        return 1

    dp[(n, k)] = get_binomial(n-1, k-1) + get_binomial(n-1, k)
    return dp[(n, k)]


print(get_binomial(n, k))
