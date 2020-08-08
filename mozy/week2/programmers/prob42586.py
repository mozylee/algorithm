# 출처: Programmers. https://programmers.co.kr/learn/courses/30/lessons/42586
# 문제: 기능개발


def minus(prog, speed):
    return prog - speed if prog > speed else 0


def pop(progresses, speeds):
    count = 0
    while progresses:
        if progresses[0] != 0:
            break
        progresses.pop(0)
        speeds.pop(0)
        count += 1
    return count


def solution(progresses, speeds):
    answer = []
    progress = [100 - x for x in progresses]

    while progress:
        for i in range(len(progress)):
            progress[i] = minus(progress[i], speeds[i])
        if progress[0] == 0:
            answer.append(pop(progress, speeds))
    return answer
