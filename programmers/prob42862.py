# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42862
# 문제: 체육복

def solution(n, lost, reserve):
    answer = n
    true_lost = lost[:]
    for l in lost:
        if l in reserve:
            reserve.remove(l)
            true_lost.remove(l)
    print(true_lost, lost)
    for student in true_lost:
        if student - 1 in reserve:
            reserve.remove(student - 1)
        elif student + 1 in reserve:
            reserve.remove(student + 1)
        else:
            answer -= 1
    return answer


print(solution(5, [2, 4], [3]))
