from collections import deque

def make_set(S: str)->set:
    ret = set()
    for i in range(len(S)):
        for j in range(i, len(S)):
            ret.add(S[i:j+1])

    return ret


S = input()
P = deque(input())
copy_set = make_set(S)

before = ""
count = 0
while P:
    before += P.popleft()
    while P and before+P[0] in copy_set:
        before += P.popleft()
    before = ""
    count += 1

print(count)
