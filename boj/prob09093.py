# 출처: https://www.acmicpc.net/problem/9093
# 문제: 단어 뒤집기


import sys
from collections import deque

sentences = deque()
n = int(sys.stdin.readline())

for _ in range(n):
    sentences.append(list(sys.stdin.readline().rstrip().split()))

while sentences:
    words = sentences.popleft()
    print(' '.join(word[::-1] for word in words))
