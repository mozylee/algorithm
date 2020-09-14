# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42584
# 문제: 주식가격
# O(n^2)... 효율성 테스트 똥망

from collections import deque


def solution(prices):
    answer = []
    prices = deque(prices)

    while prices:
        price = prices.popleft()
        days = 0
        for other_price in prices:
            days += 1
            if price > other_price:
                break
        answer.append(days)

    answer[-1] = 0
    return answer


solution([1, 2, 3, 2, 3])
