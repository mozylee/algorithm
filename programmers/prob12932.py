# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12932
# 문제: 자연수 뒤집어 배열로 만들기
# 레벨: 1

def solution(n):
    return list(map(int, reversed(str(n))))
