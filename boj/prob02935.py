import sys


read = sys.stdin.readline

print(eval("".join(read().rstrip() for _ in range(3))))