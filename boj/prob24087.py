from math import ceil


S = int(input()) - int(input())
B = int(input())

if S < 0:
    print(250)
    exit(0)
print(250 + ceil(S/B) * 100)
