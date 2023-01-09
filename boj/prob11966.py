from math import log2
import sys

read = sys.stdin.readline

print(1 if log2(int(read())).is_integer() else 0)
