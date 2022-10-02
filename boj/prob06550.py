from collections import deque
import sys


ans = []
for line in sys.stdin.readlines():
    s, t = map(deque, line.rstrip().split())

    while s:
        if not t:
            ans.append("No")
            break

        if s[0] == t[0]:
            s.popleft()
        t.popleft()

    else:
        ans.append("Yes")

print(*ans, sep="\n")
