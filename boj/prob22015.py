import sys

read = sys.stdin.readline

konpeitos = sorted(map(int, read().split()))

print(2*konpeitos[2] - sum(konpeitos[:2]))