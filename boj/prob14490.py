from math import gcd


n, m = map(int, input().split(":"))

GCD = gcd(n, m)

print(n//GCD, ":", m//GCD, sep="")
