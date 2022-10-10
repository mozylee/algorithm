import sys


read = sys.stdin.readline

n, s = read().rstrip().split()

print(sum((1 if s in read() else 0 for _ in range(int(n)))))
