# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/64062
# 문제: 징검다리 건너기

def check_stones(stones, k):
    for idx in range(len(stones)):
        if stones[idx] == 0 and idx < len(stones) - k + 1 and sum(stones[idx:idx + k]) == 0:
            return False
        stones[idx] = stones[idx] - 1 if stones[idx] > 0 else 0
    return True


def solution(stones, k):
    answer = min(stones)
    stones = [stone - answer if stone > 0 else 0 for stone in stones]
    while check_stones(stones, k):
        answer += 1
    print(answer)
    return answer


solution([2, 4, 5, 3, 2, 1, 4, 2, 5, 1], 3)
