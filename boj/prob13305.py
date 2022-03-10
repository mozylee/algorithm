import sys


read = sys.stdin.readline

N = int(read())
distances = list(map(int, read().split()))
costs = list(map(int, read().split()))

gas = costs[0]
ret = 0
for d, c in zip(distances, costs[1:]):
    ret += gas*d
    gas = min(gas, c)

print(ret)
