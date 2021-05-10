# 출처: https://www.acmicpc.net/problem/1543
# 문제: 문서 검색


import sys

string = sys.stdin.readline().rstrip()
word = sys.stdin.readline().rstrip()
length = len(word)
count = 0
skip = -1

for i, ch in enumerate(string[:-length + 1]):
    if skip > i:
        continue
    if ch == word[0] and string[i:i + length] == word:
        count += 1
        skip = i + length
print(count)
