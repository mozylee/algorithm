import sys


read = sys.stdin.readline

read()
print(*sorted(sys.stdin.read().split(), key=int), sep=" ")
