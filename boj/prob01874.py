# 출처: https://www.acmicpc.net/problem/1874
# 문제: 스택 수열


import sys

sequence = [int(sys.stdin.readline()) for _ in range(int(sys.stdin.readline()))][::-1]
stack = list()
result = list()
isNo = False
waiting = 1

while sequence:
    target = sequence.pop()
    while waiting <= target:
        stack.append(waiting)
        result.append('+')
        waiting += 1

    if stack[-1] == target:
        stack.pop()
        result.append('-')
    else:
        isNo = True
        break

print('NO' if isNo else '\n'.join(str(i) for i in result))
