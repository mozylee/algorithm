# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42885
# 문제: 구명보트

def solution(people, limit):
    answer, people_out, length = 0, 0, len(people)
    front, rear = 0, length - 1
    people.sort()
    while people_out < length:
        if people[rear] + people[front] <= limit:
            rear -= 1
            front += 1
            people_out += 2
            answer += 1
        else:
            rear -= 1
            people_out += 1
            answer += 1
    return answer


print(solution([70, 50, 80, 90, 90, 10], 100))
