# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/1845
# 문제: 폰켓몬

from collections import Counter


def solution(nums):
    phonecketmons = Counter(nums)
    answer = len(phonecketmons.keys())
    return answer if answer <= len(nums) // 2 else len(nums) // 2


print(solution([3, 3, 3, 2, 2, 4]))