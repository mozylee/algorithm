# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42840
# 문제: 모의고사

def solution(answers):
    scores = [0, 0, 0]
    students = [[1, 2, 3, 4, 5], [2, 1, 2, 3, 2, 4, 2, 5], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]

    for i, sol in enumerate(answers):
        for j, ans in enumerate(students):
            if sol == ans[i]:
                scores[j] += 1

    print(scores)
    return [i + 1 for i, v in enumerate(scores) if v == max(scores)]


solution([1, 3, 2, 4, 2])
