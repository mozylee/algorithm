import sys


read = sys.stdin.readline

N, M, q = map(int, read().split())
arr = [list(map(int, read().split())) for _ in range(N)]

for _ in range(q):
    query, *parameters = map(int, read().split())

    if query == 0:
        i, j, k = parameters
        arr[i][j] = k
        continue

    i, j = parameters

    temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp


print(*(" ".join(map(str, line)) for line in arr), sep="\n")
