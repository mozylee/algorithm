from collections import deque


N = int(input())

nums = deque(i for i in range(1, N+1))
ans = []

while nums:
    ans.append(nums.popleft())
    if nums:
        nums.append(nums.popleft())
print(*ans, sep = " ")