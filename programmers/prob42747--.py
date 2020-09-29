# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42747
# 문제: H-Index

# 처음엔 이분탐색으로 H-Index를 찾으려고 했으나 포기
def solution(citations):
    citations.sort()
    length = len(citations)
    print(citations)
    for i, citation in enumerate(citations):
        print(i, citation)
        if i + 1 >= citation:
            return length - (i + 1)


print(solution([3, 0, 6, 1, 5]))

'''

6 5 3 1 0

if c
'''
