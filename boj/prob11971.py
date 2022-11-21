import sys


read = sys.stdin.readline


def get_wv_list(arr: list, length: int):
    for _ in range(length):
        w, v = map(int, read().split())
        arr.extend([v]*w)


N, M = map(int, read().split())

roads, ways = [], []
get_wv_list(roads, N)
get_wv_list(ways, M)

ans = 0
for r, w in zip(roads, ways):
    ans = max(ans, w-r)

print(ans)