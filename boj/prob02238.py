from collections import defaultdict
import sys


read = sys.stdin.readline

U, N = map(int, read().split())

costs = defaultdict(list)

for _ in range(N):
    name, cost = read().rstrip().split()

    costs[int(cost)].append(name)

min_cost = min(costs.keys(), key=lambda x: (len(costs[x]), x))
print(costs[min_cost][0], min_cost)
