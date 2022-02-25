from math import ceil


R,C,N = map(int,input().split())

print(ceil(R/N) * ceil(C/N))