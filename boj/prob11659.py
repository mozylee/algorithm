# 출처: https://www.acmicpc.net/problem/11659
# 문제: 구간 합 구하기 4


from sys import stdin

n, m = map(int, stdin.readline().split())
nums = list(map(int, stdin.readline().split()))
sums = [nums[0]]
for i in range(1, len(nums)):
    sums.append(sums[i - 1] + nums[i])

for _ in range(m):
    i, j = map(int, stdin.readline().split())
    print(sums[j - 1] - (sums[i - 2] if i > 1 else 0))
