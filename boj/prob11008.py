import sys


read = sys.stdin.readline

ans = []
for _ in range(int(read())):
    s, p = read().rstrip().split()
    ans.append(len(s.replace(p," ")))

print(*ans, sep ="\n")