# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42884
# 문제: 단속카메라

def solution(routes):
    answer = 1
    routes.sort(key=lambda x: x[1], reverse=True)
    camera = routes.pop()[1]
    while routes:
        car = routes.pop()
        if camera < car[0]:
            answer += 1
            camera = car[1]
    return answer


print(solution())