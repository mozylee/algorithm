# 출처: https://www.acmicpc.net/problem/1302
# 문제: 베스트셀러


import sys
from collections import defaultdict

read = sys.stdin.readline
books = defaultdict(int)
for _ in range(int(read())):
    books[read().rstrip()] += 1
print(sorted(sorted(books.keys()), key=lambda x: -books[x])[0])
