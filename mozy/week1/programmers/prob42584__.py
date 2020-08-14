# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42584
# 문제: 주식가격
# O(n^2)... 효율성 테스트 똥망

def solution(prices):
    answer = []
    for i, v1 in enumerate(prices[:-1]):
        count = 0
        for v2 in prices[i + 1:]:
            count += 1
            if v1 > v2:
                answer.append(count)
                break
        if len(answer) <= i:
            answer.append(count)
    answer.append(0)
    return answer


solution([1, 2, 3, 2, 3])
