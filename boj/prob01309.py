import sys

read = sys.stdin.readline

REMAINDER = 9_901
N = int(read())

cage = [[0]*3 for _ in range(N)]
cage[0] = 1, 1, 1


for i in range(1, N):
    cage[i][0] = sum(cage[i-1])
    cage[i][1] = cage[i-1][0] + cage[i-1][2]
    cage[i][2] = cage[i-1][0] + cage[i-1][1]

    for j in range(3):
        cage[i][j] %= REMAINDER

print(sum(cage[-1]) % REMAINDER)
