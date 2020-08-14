# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42840
# 문제: 모의고사

def solution(answers):
    scores = [0, 0, 0]
    students = [[1, 3, 4, 5], [3, 1, 2, 4, 5]]
    # student1: n%5+1, student2: n(짝: [1,3,4,5] 홀:2), student3...?
    # 1: [1, 2, 3, 4, 5]
    # 2: [2, 1, 2, 3, 2, 4, 2, 5]
    # 3: [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]

    for i, answer in enumerate(answers):
        if answer == i % 5 + 1:
            scores[0] += 1
        if i % 2 == 0:
            if answer == 2:
                scores[1] += 1
        elif answer == students[0][int(i / 2) % 4]:
            scores[1] += 1
        if answer == students[1][int(i / 2) % 5]:
            scores[2] += 1
    return [i + 1 for i in range(3) if scores[i] == max(scores)]


solution([1, 2, 3, 4, 5])
