import sys


read = sys.stdin.readline

def set_dp_table():
    n = 10000

    dp = [1]*(n+1)
    for k in range(2,3+1):
        for i in range(k, n+1):
            dp[i] += dp[i-k]
    return dp

dp = set_dp_table()

print(*(dp[int(read())] for i in range(int(read()))),sep="\n")
