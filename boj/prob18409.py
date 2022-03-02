from collections import defaultdict


_ = input()

count = defaultdict(int)
for c in input():
    count[c] += 1

print(count['a']+count['e']+count['i']+count['o']+count['u'])
