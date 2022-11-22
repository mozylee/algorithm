from math import log10
import sys


read = sys.stdin.readline


def get_length(i: int) -> int:
    return int(log10(i))+1


N = int(read())

whole_length = 0

for i in range(1, 10**8+1):
    length = get_length(i)

    if whole_length+length < N:
        whole_length += length
        continue

    print(str(i)[N-whole_length-1])
    break
