import sys
from math import sqrt

read = sys.stdin.readline


def get_ratio(h: int, w: int) -> float:
    return sqrt(h ** 2 + w ** 2)


D, H, W = map(int, read().split())
ratio = get_ratio(H, W)
length = D / ratio
print(*map(lambda x: int(x * length), [H, W]))
