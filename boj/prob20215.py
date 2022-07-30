from math import sqrt


A, B = map(int, input().split())

print(A+B - sqrt(A**2+B**2))
