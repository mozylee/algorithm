# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12947
# 문제: 하샤드 수
# 레벨: 1

def solution(x):
    return x % sum(map(int, str(x))) == 0
