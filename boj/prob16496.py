import sys
from functools import cmp_to_key

read = sys.stdin.readline

read()
nums = map(str.rstrip, read().split())
nums = sorted(nums, key=cmp_to_key(lambda x, y: int(y+x)-int(x+y)))
print(int("".join(nums)))
