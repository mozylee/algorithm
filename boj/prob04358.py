from sys import stdin

trees = {}
cnt = 0
for t in stdin:
    if t == '\n':
        break
    cnt += 1
    t = t.rstrip()
    if t not in trees.keys():
        trees[t] = 0
    trees[t] += 1

for t in sorted(trees.keys()):
    print(f'{t} {trees[t]/ cnt * 100:0.4f}')
