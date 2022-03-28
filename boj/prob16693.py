from math import pi


A1, P1 = map(int, input().split())
R1, P2 = map(int, input().split())

A2 = R1**2*pi


print('Whole pizza' if P1/A1 > P2/A2 else  'Slice of pizza')
