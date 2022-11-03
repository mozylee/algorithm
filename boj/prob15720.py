from collections import deque
import sys


read = sys.stdin.readline

B, C, D = map(int, read().split())

burgers = deque(sorted(map(int, read().split())))
sides = deque(sorted(map(int, read().split())))
drinks = deque(sorted(map(int, read().split())))

before = sum(burgers+sides + drinks)
after = 0
for _ in range(min(B, C, D)):
    after += int((burgers.pop()+sides.pop()+drinks.pop())*0.9)


print(before)
print(after + sum(burgers+sides+drinks))
