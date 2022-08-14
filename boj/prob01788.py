n = int(input())

dp = [0] * (abs(n)+2)
dp[1] = 1

for i in range(2, abs(n)+1):
    dp[i] = (dp[i-1]+dp[i-2]) % 1000000000


print(0 if n == 0 else -1 if n % 2 == 0 and n < 0 else 1)
print(dp[abs(n)])
