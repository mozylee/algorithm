import sys
from functools import cmp_to_key

read = sys.stdin.readline

K, N = map(int, read().split())
nums = [int(read()) for _ in range(K)]
maxN = max(nums)
nums += [maxN for _ in range(N-K)]
nums = sorted(map(str, nums), key=cmp_to_key(lambda x, y: int(y+x)-int(x+y)))
print("".join(nums))
