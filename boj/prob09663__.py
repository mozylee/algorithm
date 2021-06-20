# 출처: https://www.acmicpc.net/problem/9663
# 문제: N-Queen


def is_available(row):
    for i in range(row):
        if rows[row] == rows[i] or abs(rows[row] - rows[i]) == row - i:
            return False
    return True


def DFS(row):
    global result
    if row == N:
        result += 1
    else:
        for col in range(N):
            rows[row] = col
            if is_available(row):
                DFS(row + 1)


N = int(input())
rows = {i: 0 for i in range(N)}
result = 0
DFS(0)
print(result)
