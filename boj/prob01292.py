# 출처: https://www.acmicpc.net/problem/1292
# 문제: 쉽게 푸는 문제


nums = [i for i in range(1, 45 + 1) for _ in range(i)]
a, b = map(int, input().split())
print(sum(nums[a - 1 : b]))

