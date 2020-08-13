# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/64065
# 문제: 튜플

def solution(s):
    p = []
    answer = []
    index = 0
    for i, v in enumerate(s):
        if v == '{':
            index = i
        elif v == '}' and i < len(s) - 1:
            p.append(list(map(int, s[index + 1:i].split(','))))
    p = sum(sorted(p, key=len), [])

    for i in p:
        if any([i == num for num in answer]):
            continue
        answer.append(i)
    print(answer)
    return answer


solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")
