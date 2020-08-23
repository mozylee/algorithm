# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42587
# 문제: 프린터

def solution(priorities, location):
    answer = 0
    while priorities:
        if priorities[0] == max(priorities):
            answer += 1
            if location == 0:
                return answer
            priorities.pop(0)
            location -= 1
        else:
            priorities.append(priorities.pop(0))
            location = len(priorities) - 1 if location == 0 else location - 1
