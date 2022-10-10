import sys


read = sys.stdin.readline

coords = sorted(map(int, read().split()))

print(abs(coords[0]-coords[2])+abs(coords[1]-coords[3]))
