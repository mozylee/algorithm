# 출처: https://www.acmicpc.net/problem/2630
# 문제: 색종이 만들기

from sys import stdin

board = [list(map(int, stdin.readline().split())) for _ in range(int(stdin.readline()))]
white = 0
blue = 0


def divide(board):
    global white, blue
    sum_board = sum(sum(board, []))
    size = len(board)
    print(board)
    if size == 1:
        if board[0][0] == 0:
            white += 1
            print('white: ', white)
        else:
            blue += 1
            print('blue: ', blue)
        return
    if sum_board == size ** 2:
        blue += 1
        print('blue: ', blue)
        return
    elif sum_board == 0:
        white += 1
        print('white: ', white)
        return

    board1, board2, board3, board4 = list(), list(), list(), list()
    for i in range(size // 2):
        board1.append(board[i][:size // 2])
        board2.append(board[i][size // 2:])
        board3.append(board[i + size // 2][:size // 2])
        board4.append(board[i + size // 2][size // 2:])
    divide(board1)
    divide(board2)
    divide(board3)
    divide(board4)


divide(board)
print(white)
print(blue)
