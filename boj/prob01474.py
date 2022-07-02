from collections import deque
import sys

read = sys.stdin.readline
N, M = map(int, read().split())

words = []
length = 0

lowers, uppers = deque(), deque()
for i in range(N):
    word = read().rstrip()
    words.append(word)
    length += len(word)

    if i > 0:
        if word[0].islower():
            lowers.append(i)
        else:
            uppers.appendleft(i)

M -= length
share, remainder = M//(N-1), M % (N-1)

amounts = {i: share for i in range(N)}
while lowers and remainder > 0:
    amounts[lowers.popleft()] += 1
    remainder -= 1
while uppers and remainder > 0:
    amounts[uppers.popleft()] += 1
    remainder -= 1

print(words[0] + "".join("_"*amounts[i+1]+w for i, w in enumerate(words[1:])))
