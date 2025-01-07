import sys


read = sys.stdin.readline

MAX = 251
dp = [1, 1] + [0] * MAX

for i in range(2, MAX):
    dp[i] = dp[i-1] + dp[i-2] * 2

print(dp)

print("\n".join(str(dp[int(read())]) for _ in range(5)))

# print("\n".join(str(sum(dp[int(i)]) for i in sys.stdin.readlines())))
