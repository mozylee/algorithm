import sys


read = sys.stdin.readline

K, L = map(int, read().split())

for i in range(2, L):
    if K%i==0:
        print(f"BAD {i}")
        break
else:
    print("GOOD")