def solution(board, moves):
    answer = 0
    vertical_board = [[] for i in board]
    for i in reversed(board):
        for idx, j in enumerate(i):
            if j == 0:
                continue
            vertical_board[idx].append(j)

    bascket = []
    for move in moves:
        print(move)
        print(vertical_board,bascket)
        if not vertical_board[move - 1]:
            continue
        doll = vertical_board[move - 1].pop()

        if bascket:
            if doll == bascket[-1]:
                bascket.pop()
                answer += 2
            else:
                bascket.append(doll)
        else:
            bascket.append(doll)
    return answer


print(solution([[0, 0, 0, 0, 0], [0, 0, 1, 0, 3], [0, 2, 5, 0, 1], [4, 2, 4, 4, 2], [3, 5, 1, 3, 1]],
               [1, 5, 3, 5, 1, 2, 1, 4]))
