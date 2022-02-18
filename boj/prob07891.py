import sys


read = sys.stdin.readline

print(*[sum(map(int,read().split())) for _ in range(int(read()))],sep="\n")