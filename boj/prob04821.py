import sys


read = sys.stdin.readline

ans = []
pages = set()
while True:
    N = int(read())
    if N == 0:
        break

    for p in read().rstrip().split(","):
        if "-" not in p:
            if int(p) <= N :
                pages.add(int(p))
            continue

        low, high = map(int, p.split("-"))

        if low > high or low > N:
            continue

        pages.update(range(low, min(high, N)+1))

    ans.append(len(pages))
    pages.clear()

print(*ans, sep="\n")
