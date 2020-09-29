# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12905
# 문제: 가장 큰 정사각형 찾기
# 레벨: 2

def solution(board):
    answer = 1
    row = min(len(board), len(board[0]))
    i, j = 0, 0
    while answer == 1:
        print(board[i])
        answer += 1
        if answer > 1:
            break
    return answer


print(solution([[0, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1], [0, 0, 1, 0]]))
