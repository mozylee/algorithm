from itertools import combinations


friends = list(map(int, input().split()))

min_gap = 1e9

for c1, c2 in combinations(range(4), 2):
    print(c1, c2)
    min_gap = min(min_gap, abs(sum(friends)-2*(friends[c1]+friends[c2])))

print(min_gap)
