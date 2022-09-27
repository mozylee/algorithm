import sys


read = sys.stdin.readline

ans = []
for _ in range(int(read())):
    M, N = map(int, read().split())
    nums = {i: 1 for i in range(M)}

    for _ in range(N):
        for i, num in enumerate(map(int, read().split())):
            nums[i] *= num

    ans.append(max(nums.keys(), key=lambda x: (nums[x], x))+1)

print(*ans, sep="\n")
