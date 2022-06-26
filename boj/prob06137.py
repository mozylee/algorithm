from collections import deque

S = "".join(input() for _ in range(int(input())))
s = deque(S)
_s = deque(reversed(S))


def compare() -> int:
    for i in range(len(s)):
        if s[i] < _s[i]:
            return True
        elif s[i] > _s[i]:
            return False
    return True


T = []
length = 0

while s:
    if compare():
        T.append(s.popleft())
        _s.pop()
    else:
        T.append(_s.popleft())
        s.pop()
    length += 1

    if length > 0 and length % 80 == 0:
        T.append("\n")

print("".join(T))
