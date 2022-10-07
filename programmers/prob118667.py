from collections import deque


def solution(queue1: list, queue2: list) -> int:
    queue1, queue2 = map(deque, (queue1, queue2))
    visited = set()
    sum1, sum2 = sum(queue1), sum(queue2)

    count = 0
    while queue1 and queue2:
        trial = (queue1[0], queue2[0], sum1, sum2)
        if(trial in visited):
            break
        if(sum1 < sum2):
            sum2 -= queue2[0]
            sum1 += queue2[0]
            queue1.append(queue2.popleft())
        elif (sum1 > sum2):
            sum1 -= queue1[0]
            sum2 += queue1[0]
            queue2.append(queue1.popleft())
        else:
            return count
        count += 1
        visited.add(trial)
    return -1


test_cases = [[[3, 2, 7, 2], [4, 6, 5, 1]],  # 2
              [[1, 2, 1, 2], [1, 10, 1, 2]],  # 7
              [[1, 1], [1, 5]]]  # -1

for q1, q2 in test_cases:
    print(solution(q1, q2))
