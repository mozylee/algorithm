import sys


read = sys.stdin.readline

read()

max_day = 0
for i, t in enumerate(sorted(map(int, read().split()), reverse=True)):
    max_day = max(max_day, i+t)

print(max_day+2)
