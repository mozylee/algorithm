# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12943
# 문제: 콜라츠 추측
# 레벨: 1

def solution(num):
    answer = 0
    while num > 1:
        if answer > 500:
            return -1
        answer += 1
        if num % 2:
            num = num * 3 + 1
        else:
            num //= 2
    return answer


print(solution(626331))
