from collections import deque
import sys

read = sys.stdin.readline

n, T = map(int, read().split())

tasks = deque(map(int,read().split()))

total = 0
count=0
while tasks and total+tasks[0]<=T:
    total+=tasks.popleft()
    count+=1

print(count)