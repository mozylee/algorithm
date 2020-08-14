# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42576
# 문제: 완주하지 못한 선수

def solution(participant, completion):
    ps = {}
    for p in participant:
        if p in ps:
            ps[p] += 1
        else:
            ps[p] = 1

    for c in completion:
        ps[c] -= 1
        if ps[c] == 0:
            del ps[c]

    print(list(ps.keys())[0])
    return list(ps.keys())[0]


solution(['marina', 'josipa', 'nikola', 'vinko', 'filipa'], ['josipa', 'filipa', 'marina', 'nikola'])
