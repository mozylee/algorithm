import sys


read = sys.stdin.readline

ans = []
for _ in range(int(read())):
    N = int(read())
    applicants = sorted((tuple(map(int, read().split()))
                        for _ in range(N)), key=lambda x: x[0])
    _after = []
    before = 1e9
    for a in applicants:
        if a[1] > before:
            continue
        before = a[1]
        _after.append(a)

    applicants = sorted(_after, key=lambda x: x[1])
    _after = []
    before = 1e9
    for a in applicants:
        if a[0] > before:
            continue
        before = a[0]
        _after.append(a)

    ans.append(len(_after))

print(*ans, sep="\n")
