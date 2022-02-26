T = int(input())

print(sum(1 if i==T else 0 for i in map(int,input().split())))