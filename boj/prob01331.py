import sys


read = sys.stdin.readline

visited = set()
moves = set((i, j) for i in (-1, 1, 2, -2)
            for j in (-1, 1, 2, -2)
            if abs(i) != abs(j))


def get_move(before, now):
    return ord(before[0])-ord(now[0]), int(before[-1])-int(now[-1])


def isInvalid(before, now):
    return now in visited or get_move(before, now) not in moves


flag = True
before = read().rstrip()
first = before
visited.add(before)
for _ in range(35):
    now = read().rstrip()

    if isInvalid(before, now):
        flag = False
        continue
    visited.add(now)
    before = now


print("Valid" if flag and get_move(before, first) in moves else "Invalid")
