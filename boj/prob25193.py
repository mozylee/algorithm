from math import ceil
import sys


read = sys.stdin.readline

read()

chickens, others = 0, 0

for c in read().rstrip():
    chickens += 1 if c == "C" else 0
    others += 1 if c != "C" else 0

print(ceil(chickens/(others+1)))
