# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42627
# 문제: 디스크 컨트롤러

import heapq


def solution(jobs):
    answer, k = 0, len(jobs)
    jobs_done = 0

    jobs.sort()
    h = []
    while jobs or h:
        i = 0
        while jobs:
            job = jobs.pop(0)
            if job[0] > answer:
                jobs.insert(0, job)
                break
            heapq.heappush(h, list(reversed(job)))
            i += 1
        if h:
            job = heapq.heappop(h)
            answer += job[0]
            jobs_done += answer - job[1]
        else:
            answer += 1
    return jobs_done // k


print(solution([[0, 3], [1, 9], [2, 6]]))
