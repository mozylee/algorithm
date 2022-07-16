from math import ceil


M, S, G = map(int, input().split())
A, B = map(float, input().split())
L, R = map(int, input().split())

l, r = ceil(M/S)+R/B, ceil(M/G)+L/A
print('friskus' if l > r else 'latmask')
