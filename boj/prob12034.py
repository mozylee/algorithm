from collections import deque
import sys


read = sys.stdin.readline

ans = []
for i in range(int(read())):
    N = int(read())
    prices = map(int, read().split())

    discounted = deque()

    ret = []
    for p in prices:
        if discounted and discounted[0] == p*3//4:
            ret.append(str(discounted.popleft()))
            continue

        discounted.append(p)

    ans.append(f"Case #{i+1}: {' '.join(ret)}")

print(*ans, sep="\n")
