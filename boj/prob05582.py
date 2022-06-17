A = input()
B = input()

len_A, len_B = len(A)+1, len(B)+1
dp = [[0]*len_B for _ in range(len_A)]

max_length = 0
for i in range(1, len_A):
    for j in range(1, len_B):
        dp[i][j] = (dp[i-1][j-1] + 1) if A[i-1] == B[j-1] else 0
        max_length = max(max_length, dp[i][j])

print(max_length)
