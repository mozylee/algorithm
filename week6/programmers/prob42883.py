# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42883
# 문제: 큰 수 만들기

def solution(number, k):
    answer = []
    for i in range(len(number)):
        if not answer:
            answer.append(number[i])
            continue
        while k > 0 and answer and answer[-1] < number[i]:
            k -= 1
            answer.pop()
            if k == 0:
                answer += number[i:]
                break
        if k == 0:
            break
        answer.append(number[i])

    return ''.join(answer) if k == 0 else ''.join(answer[:-k])
