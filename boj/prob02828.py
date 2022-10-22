import sys


read = sys.stdin.readline

N, M = map(int, read().split())

ans = 0
left, right = 1, M
for a in (int(read()) for _ in range(int(read()))):
    if left <= a <= right:
        continue

    gap = 0
    if left > a:
        gap = left-a
        right -= gap
        left = a
    else:
        gap = a-right
        left += gap
        right = a
    
    ans+=gap

print(ans)
