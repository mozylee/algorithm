import sys


read = sys.stdin.readline
WIDTH, HEIGHT = range(2)


N = int(read())
squares = [tuple(map(int, read().split())) for _ in range(N)]
dp = [[0]*2 for _ in range(N)]

dp[0][WIDTH] = squares[0][WIDTH]
dp[0][HEIGHT] = squares[0][HEIGHT]
for i in range(1, N):
    dp[i][WIDTH] = max(dp[i-1][WIDTH]+(abs(squares[i][HEIGHT]-squares[i-1][HEIGHT])),
                       dp[i-1][HEIGHT]+(abs(squares[i][HEIGHT]-squares[i-1][WIDTH]))) + squares[i][WIDTH]
    dp[i][HEIGHT] = max(dp[i-1][WIDTH]+(abs(squares[i][WIDTH]-squares[i-1][HEIGHT])),
                        dp[i-1][HEIGHT]+(abs(squares[i][WIDTH]-squares[i-1][WIDTH]))) + squares[i][HEIGHT]

print(max(dp[-1]))
