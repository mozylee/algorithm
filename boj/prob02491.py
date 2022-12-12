import sys


read = sys.stdin.readline


N = int(read())
sequence = list(map(int, read().split()))

increases = [1]*N
decreases = [1]*N
for i in range(1, N):
    increases[i] = 1 + (increases[i-1] if sequence[i] >= sequence[i-1] else 0)
    decreases[i] = 1 + (decreases[i-1] if sequence[i] <= sequence[i-1] else 0)

print(max(increases+decreases))
