# 출처: https://www.acmicpc.net/problem/2592
# 문제: 대표값


from collections import Counter
import sys

read = sys.stdin.readline

nums = [int(read()) for _ in range(10)]

print(sum(nums) // 10)
print(Counter(nums).most_common(1)[0][0])
