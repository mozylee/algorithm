import sys


read = sys.stdin.readline

ans = []

a, b, c, d = map(int, read().split())
count = 0
while a+b+c+d > 0:
    if a == b == c == d:
        ans.append(count)
        a, b, c, d = map(int, read().split())
        count = 0
        continue
    
    a, b, c, d = abs(a-b), abs(b-c), abs(c-d), abs(d-a)
    count += 1


print(*ans, sep="\n")
