import sys


read = sys.stdin.readline

location = {i: i for i in range(1, 4)}

for _ in range(int(read())):
    A, B = map(int, read().split())

    location[A],location[B] = location[B], location[A]


print(*filter(lambda x:location[x]==1, location.keys()))