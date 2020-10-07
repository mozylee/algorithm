# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12982
# 문제: 예산
# 레벨: 1

def solution(d, budget):
    d.sort(reverse=True)
    answer = 0
    while d and budget >= d[-1]:
        answer += 1
        budget -= d.pop()
    return answer
