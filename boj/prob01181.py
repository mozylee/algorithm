# 출처: https://www.acmicpc.net/problem/1181
# 문제: 단어 정렬


import sys

n = int(sys.stdin.readline())
words = set()
for _ in range(n):
    words.add(sys.stdin.readline().rstrip())

print("\n".join(sorted(words, key=lambda x: (len(x), x))))
