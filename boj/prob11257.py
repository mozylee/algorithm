import sys


read = sys.stdin.readline

A, B, C = 35*0.3, 25*0.3, 40*0.3

ans = []
for _ in range(int(read())):
    a, l1, l2, l3 = map(int, read().split())
    s = l1+l2+l3
    flag = l1 < A or l2 < B or l3 < C or s < 55
    ans.append(f'{a} {s} {"PASS" if not flag else "FAIL"}')


print(*ans, sep = "\n")
