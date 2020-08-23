# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/64061
# 문제: 크레인 인형뽑기 게임

from collections import deque


def solution(board, moves):
    answer = 0
    boards = [[horizon[i] for horizon in reversed(board) if horizon[i] != 0] for i in range(len(board[0]))]
    basket = deque([])

    for move in moves:
        if not boards[move - 1]:
            continue
        doll = boards[move - 1].pop()
        if basket and basket[-1] == doll:
            basket.pop()
            answer += 2
        else:
            basket.append(doll)
    print(answer)
    return answer


solution([[0, 0, 0, 0, 0], [0, 0, 1, 0, 3], [0, 2, 5, 0, 1], [4, 2, 4, 4, 2], [3, 5, 1, 3, 1]],
         [1, 5, 3, 5, 1, 2, 1, 4])
