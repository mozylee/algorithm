# 출처: https://www.acmicpc.net/problem/2780
# 문제: 주사위 세개

a, b, c = map(int, input().split())
k = set()
size = 0
v = 0
for i in (a, b, c):
    if i in k:
        v = i
        size += 1
        continue
    k.add(i)


if size == 2:
    print(10000 + 1000 * v)
elif size == 1:
    print(1000 + 100 * v)
else:
    print(100 * max(k))
