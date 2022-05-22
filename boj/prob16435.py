from collections import deque
import sys

read = sys.stdin.readline

N, L = map(int, read().split())
fruits = deque(sorted(map(int, read().split())))

while fruits and fruits[0]<= L:
    L+=1
    fruits.popleft()

print(L)