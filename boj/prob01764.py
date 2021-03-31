# 출처: https://www.acmicpc.net/problem/1764
# 문제: 듣보잡


import sys

heard, seen = set(), set()
n, m = map(int, sys.stdin.readline().split())

for _ in range(n):
    heard.add(sys.stdin.readline().rstrip())
for _ in range(m):
    seen.add(sys.stdin.readline().rstrip())

result = heard & seen

print(len(result))
print('\n'.join(name for name in sorted(result)))
