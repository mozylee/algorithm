# 출처: https://www.acmicpc.net/problem/1018
# 문제: 체스판 다시 칠하기

from sys import stdin

n, m = map(int, stdin.readline().split())
board = [stdin.readline().rstrip() for _ in range(n)]
result = 64
for i in range(n - 7):
    for j in range(m - 7):
        count_w = 0
        count_b = 0
        for a in range(i, i + 8):
            for b in range(j, j + 8):
                if (a + b) % 2:
                    if board[a][b] == 'W':
                        count_w += 1
                    else:
                        count_b += 1
                else:
                    if board[a][b] == 'B':
                        count_w += 1
                    else:
                        count_b += 1
        result = min(result, count_w, count_b)
print(result)
