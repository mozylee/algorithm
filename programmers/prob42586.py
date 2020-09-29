# 출처: Programmers. https://programmers.co.kr/learn/courses/30/lessons/42586
# 문제: 기능개발


def solution(progresses, speeds):
    answer = []

    # 중요!: Math.ceil 대신 -((progress - 100) // speed) 사용
    progress_queue = [-((progress - 100) // speed) for progress, speed in zip(progresses, speeds)]
    count = 0
    while progress_queue:
        if progress_queue[0] == 0:
            progress_queue.pop(0)
            count += 1
        else:
            if count > 0:
                answer.append(count)
                count = 0
            progress_queue = [p - 1 if p != 0 else 0 for p in progress_queue]
    if count > 0:
        answer.append(count)
    return answer


print(solution([76, 12, 66, 78, 9], [11, 45, 67, 88, 1]))
