# 출처: https://www.acmicpc.net/problem/1062
# 문제: 가르침


import sys
from itertools import combinations
from collections import defaultdict

read = sys.stdin.readline

spell = {"a", "n", "t", "i", "c"}

n, k = map(int, read().split())
spells = set()
words = defaultdict(int)
if k < 5:
    print(0)
    exit(0)

for _ in range(n):
    word = set(read().rstrip()[4:-4]) - spell
    spells.update(word)
    words["".join(sorted(word))] += 1

max_count = 0
for com in combinations(spells, k - 5):
    count = 0
    for word in words:
        check = 0
        length = len(word)
        for c in word:
            if c in com:
                check += 1
        if check == length:
            count += words[word]

    max_count = max(max_count, count)

print(max_count)
