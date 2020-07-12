# Backjoon Online Judge: https://www.acmicpc.net/problem/2920
# 문제: 나머지

# 두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다. 예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다. 
# 수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.


import sys
inputs = sys.stdin.readlines()

#정렬하고 중복된거 싹 지우고 len() 떄려도 좋을듯??? set을 쓰면 되려나?
nums = list(map(str.strip, inputs))
nums = [int(x) % 42 for x in nums]
nums.sort()


count = 1
firstValue = nums[0]
for i in nums:
    if i != firstValue:
        firstValue = i
        count += 1

print(count)
