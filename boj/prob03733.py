import sys


for line in sys.stdin.readlines():
    N, S = map(int, line.split())
    print(S//(N+1))
