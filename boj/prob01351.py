from collections import defaultdict
from math import floor


A = defaultdict(int)
A[0] = 1


def get_A(i: int) -> int:
    if(A[i] != 0):
        return A[i]
    A[i] = get_A(floor(i/P)) + get_A(floor(i/Q))
    return A[i]


N, P, Q = map(int, input().split())
print(get_A(N))
