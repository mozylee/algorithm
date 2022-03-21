from collections import defaultdict, deque


counts = defaultdict(int)

for c in input():
    counts[c] += 1

length = 0
odds = 0
odd = 'EMPTY'
for k, v in counts.items():
    length += v
    if v % 2 == 1:
        odds += 1
        odd = k

if (length % 2 == 0 and odds > 0) or (length % 2 == 1 and odds != 1):
    print("I'm Sorry Hansoo")
    exit(0)


res = deque()
if odd != 'EMPTY':
    res.append(odd)
    counts[odd] -= 1

for k, v in sorted(counts.items(), reverse=True):
    res.append(k*(v//2))
    res.appendleft(k*(v//2))

print("".join(res))
