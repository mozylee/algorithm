# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42861
# 문제: 섬 연결하기

def solution(n, costs):
    answer = 0
    costs.sort(key=lambda x: x[2])
    islands = set([costs[0][0]])
    while len(islands) != n:
        for i, cost in enumerate(costs):
            if cost[0] in islands and cost[1] in islands:
                continue
            if cost[0] in islands or cost[1] in islands:
                answer += cost[2]
                islands.update([cost[0],cost[1]])
                costs.pop(i)
                break
    return answer


print(solution(5, [[0, 1, 1], [3, 1, 1], [0, 2, 2], [0, 3, 2], [0, 4, 100]]))
