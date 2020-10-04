# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12910
# 문제: 나누어 떨어지는 숫자 배열
# 레벨: 1

def solution(arr, divisor):
    answer = sorted([value for value in arr if value % divisor == 0])
    return answer if len(answer) > 0 else [-1]
