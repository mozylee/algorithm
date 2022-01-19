import math

n = int(input())
files = list(map(int, input().split()))
size = int(input())
print(sum(math.ceil(f/size)*size for f in files))
