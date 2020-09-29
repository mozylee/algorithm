# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/49993
# 문제: 스킬트리

def solution(skill, skill_trees):
    answer = 0
    for tree in skill_trees:
        is_legal, is_founded = True, False
        i = len(tree)
        for s in reversed(skill):
            i = tree[:i].find(s)
            if not is_founded:
                if i > -1:
                    is_founded = True
                else:
                    i = len(tree)
                continue
            if i == -1:
                is_legal = False
                break
        if is_legal:
            answer += 1
    return answer


print(solution('CBD', ['AAAAAAAAAERT']))
