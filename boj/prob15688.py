import sys


read = sys.stdin.readline

print(*sorted(int(read()) for _ in range(int(read()))), sep="\n")
