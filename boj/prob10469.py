from collections import deque
import sys


read = sys.stdin.readline

queens = deque((i, j) for i in range(8)
               for j, c in enumerate(read().rstrip()) if c == '*')

while queens:
    queen = queens.popleft()

    if any(q[0] == queen[0] or q[1] == queen[1] or abs(q[1]-queen[1]) == q[0]-queen[0] for q in queens):
        print("invalid")
        break

else:
    print("valid")
