# Backjoon Online Judge: https://www.acmicpc.net/problem/1157
# 내용없음

import sys
from collections import Counter

char_counter = Counter(sys.stdin.readline().rstrip().upper())
max_char = list(filter(lambda x: x[1] == max(char_counter.values()), char_counter.items()))
print(max_char.pop()[0] if len(max_char) == 1 else '?')
