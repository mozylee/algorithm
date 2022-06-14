from collections import Counter, deque

N = input()
count = Counter(N)

before = deque(reversed(N))
ret = deque()

for k in ('0', '1'):
    amount = count[k]//2

    while before:
        top = before.popleft()
        if amount>0 and top == k:
            amount -= 1
            continue
        ret.append(top)
    before = deque(reversed(ret))
    ret = deque()

print("".join(reversed(before)))
