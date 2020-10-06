# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12933
# 문제: 정수 내림차순으로 배치하기
# 레벨: 1

def solution(n):
    return int(''.join(sorted(str(n), reverse=True)))
