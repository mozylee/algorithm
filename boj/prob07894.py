from math import log10
import sys


read = sys.stdin.readline

length = [0]*10_000_001

for i in range(1, 10_000_001):
    length[i] = log10(i) + length[i-1]


print(*(int(length[int(read())])+1 for _ in range(int(read()))),sep="\n")