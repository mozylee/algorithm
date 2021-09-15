import sys
from math import gcd

read = sys.stdin.readline
s = read().rstrip()
t = read().rstrip()

gcd_length = gcd(len(s), len(t))
ss = s*len(t)*gcd_length
tt = t*len(s)*gcd_length

print(1 if ss == tt else 0)
