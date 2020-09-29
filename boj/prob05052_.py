# Backjoon Online Judge: https://www.acmicpc.net/problem/5052
# 문제: 전화번호 목록

# 전화번호 목록이 주어진다. 이때, 이 목록이 일관성이 있는지 없는지를 구하는 프로그램을 작성하시오.
# 전화번호 목록이 일관성을 유지하려면, 한 번호가 다른 번호의 접두어인 경우가 없어야 한다.
# 예를 들어, 전화번호 목록이 아래와 같은 경우를 생각해보자
# 긴급전화: 911
# 상근: 97 625 999
# 선영: 91 12 54 26
# 이 경우에 선영이에게 전화를 걸 수 있는 방법이 없다.
# 전화기를 들고 선영이 번호의 처음 세 자리를 누르는 순간 바로 긴급전화가 걸리기 때문이다. 따라서, 이 목록은 일관성이 없는 목록이다. 

# 풀긴 했는데 조금 추가할만한게 있을듯?


import sys
from collections import deque

inputs = deque(sys.stdin.readlines())
inputs.popleft()
while len(inputs) > 0:
    m = int(inputs.popleft())

    # 원래는 numbers를 딕셔너리로 해서 인덱싱하는 시간을 줄이려고 함
    # 리스트로하니까 25%에서 시간초과 (딕셔너리는 12%)
    numbers = []
    isGood = True

    # 이게 그 딕셔너리 sorting
    # for i in range(m):
    #     numbers[i] = inputs.popleft().strip()
    # numbers = dict((x, y) for x, y in sorted(numbers.items(), key=(lambda x: len(x[1]))))

    # 리스트로 바꾸고 리스트 sorting
    for i in range(m):
        numbers.append(inputs.popleft().strip())
    numbers = sorted(numbers, key=len)

    # 여기는 더 줄이기 애매하고
    for i in range(m):
        if i > 0:
            for j in range(i):
                if len(numbers[i]) > len(numbers[j]) and numbers[i][:len(numbers[j])] == numbers[j]:
                    isGood = False
                    break
        if not isGood:
            break
    sys.stdout.write('YES\n' if isGood else 'NO\n')
