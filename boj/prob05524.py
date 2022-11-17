import sys


read =sys.stdin.readline

print(*(read().rstrip().lower() for _ in range(int(read()))), sep="\n")