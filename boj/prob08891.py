import sys


read = sys.stdin.readline

k = 0
MAX = 500


def get_k():
    global k
    k += 1
    return k


def get_coordinates(d, dots):
    d = int(d)

    for i in range(1, MAX+1):
        if dots[(1, i)] < d:
            continue

        if dots[(1, i)] == d:
            return 1, i

        for j in range(1, i):
            if dots[(j, i-j)] == d:
                return j, i-j


dots = {(j, i-j+1): get_k() for i in range(1, MAX+1) for j in range(1, i+1)}
ans = []
for _ in range(int(read())):
    d1, d2 = map(lambda x: get_coordinates(x, dots), read().split())
    ans.append(dots[(d1[0]+d2[0], d1[1]+d2[1])])

print(*ans, sep="\n")