import sys

read = sys.stdin.readline

guests = sorted((int(read()) for _ in range(int(read()))),reverse= True)

tip = 0

for i, t in enumerate(guests):
    if i>=t:
        break
    tip += t-i

print(tip)