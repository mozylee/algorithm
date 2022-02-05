def solution(board, skill):
    R, C = len(board) + 1, len(board[0]) + 1
    diff = [[0] * C for _ in range(R)]

    for t, r1, c1, r2, c2, d in skill:
        d *= -1 if t == 1 else 1
        set_diff(diff, r1, c1, r2, c2, d)

    for i in range(1, R):
        diff[i][0] += diff[i - 1][0]
        diff[0][i] += diff[0][i - 1]

    ans = 0
    for i in range(1, R):
        for j in range(1, C):
            diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1]
            ans += 1 if board[i - 1][j - 1] + diff[i - 1][j - 1] > 0 else 0
    return ans


def set_diff(diff, r1, c1, r2, c2, d):
    diff[r1][c1] += d
    diff[r2 + 1][c2 + 1] += d
    diff[r2 + 1][c1] -= d
    diff[r1][c2 + 1] -= d


test_cases = [
    [
        [[5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5]],
        [
            [1, 0, 0, 3, 4, 4],
            [1, 2, 0, 2, 3, 2],
            [2, 1, 0, 3, 1, 2],
            [1, 0, 1, 3, 3, 1],
        ],
    ],
    [
        [[1, 2, 3], [4, 5, 6], [7, 8, 9]],
        [[1, 1, 1, 2, 2, 4], [1, 0, 0, 1, 1, 2], [2, 2, 0, 2, 0, 100]],
    ],
]
# 10
# 6
for b, s in test_cases:
    print(solution(b, s))
