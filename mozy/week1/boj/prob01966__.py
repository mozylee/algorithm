# Backjoon Online Judge: https://www.acmicpc.net/problem/1966
# 문제: 프린터 큐

# 우선순위 큐 문제
# 다른 좋은 방법을 찾아야 할 것 같다.


import sys

num = input()
inputs = sys.stdin.readlines()
args = list(map(str.split, inputs))
args = [list(map(int, x)) for x in args]

for x in range(int(len(args) / 2)):
    count = 0
    idx = args[x * 2][1]
    i = 0

    # 걍 idx가 빠져 나올 때까지 무한 반복시킴
    while (True):
        # 현재 큐의 맨 앞에 있는게 우선순위가 제일 높은지 확인
        if args[x * 2 + 1][0] >= max(args[x * 2 + 1]):
            count += 1
            # 높으면 빠져 나옴(count 증가). 근데 idx가 빠져나온거면 반복 끝냄
            if idx == 0:
                print(count)
                break
            # 맨 앞에 있는게 idx가 아니면 걍 pop후 idx한칸 떙김
            args[x * 2 + 1].pop(0)
            idx -= 1
        else:
            # 맨 앞에 있는데 우선순위가 제일 높지 않으면 맨 뒤로 보냄
            if idx == 0:
                idx = len(args[x * 2 + 1]) - 1
            else:
                idx -= 1
            args[x * 2 + 1].append(args[x * 2 + 1].pop(0))
        i += 1
