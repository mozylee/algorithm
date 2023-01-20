import sys


read = sys.stdin.readline


max_prize = 0

for _ in range(int(read())):
    a, b, c = sorted(map(int, read().split()))

    if a == b == c:
        max_prize = max(max_prize, 10_000 + b*1_000)

    elif a == b or b == c:
        max_prize = max(max_prize, 1_000 + b*100)

    else:
        max_prize = max(max_prize, c*100)

print(max_prize)