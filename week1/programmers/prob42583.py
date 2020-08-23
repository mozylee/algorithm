# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42583
# 문제: 다리를 지나는 트럭

from collections import deque


def solution(bridge_length, weight, truck_weights):
    time = 0
    trucks = deque([[weight, 0] for weight in truck_weights])
    bridge = deque([])
    bridge.append(trucks.popleft())

    while trucks:
        for truck in bridge:
            truck[1] += 1
        if bridge[0][1] == bridge_length:
            bridge.popleft()
        if weight - sum(map(lambda x: x[0], bridge)) >= trucks[0][0]:
            bridge.append(trucks.popleft())
        time += 1
    return time + (bridge_length - bridge.pop()[1]) + 1


print(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]), '\n')
print(solution(2, 10, [7, 4, 5, 6]))
