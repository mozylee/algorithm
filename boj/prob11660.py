# 출처: https://www.acmicpc.net/problem/11660
# 문제: 구간 합 구하기 5


from sys import stdin

n, m = map(int, stdin.readline().split())
nums = [list(map(int, stdin.readline().split())) for _ in range(n)]
sums = [[0 for _ in range(n + 1)] for _ in range(n)]

for i in range(n):
    for j in range(1, n + 1):
        sums[i][j] += sums[i][j - 1] + nums[i][j - 1]

for _ in range(m):
    x1, y1, x2, y2 = map(int, stdin.readline().split())
    result = 0
    for i in range(x2 - x1 + 1):
        result += sums[x1 + i - 1][y2] - sums[x1 + i - 1][y1 - 1]
    print(result)
