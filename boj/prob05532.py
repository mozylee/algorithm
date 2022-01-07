from math import ceil
from re import A


L = int(input())
A = int(input())
B = int(input())
C = int(input())
D = int(input())

print(L-max(ceil(A / C), ceil(B / D)))
