# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/64062
# 문제: 징검다리 건너기

def check_stones(stones, k):
    for idx, stone in enumerate(stones[:-(k - 1)]):
        if stone == 0 and sum(stones[idx:idx + k]) == 0:
            return False
    return True


def solution(stones, k):
    answer = 0

    while check_stones(stones, k):
        stones = list(map(lambda x: x - 1 if x > 0 else 0, stones))
        answer += 1

    print(answer)
    return answer


solution([2, 4, 5, 3, 2, 1, 4, 2, 5, 1], 3)
