# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42576
# 문제: 완주하지 못한 선수

def solution(participant, completion):
    participant.sort()
    completion.sort()

    for p, c in zip(participant, completion):
        if p != c:
            return p
    return participant[-1]


solution(['mislav', 'stanko', 'mislav', 'ana'], ['stanko', 'ana', 'mislav'])
