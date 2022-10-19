from itertools import permutations
from math import floor, sqrt
import sys


read = sys.stdin.readline

yumi = tuple(map(int, read().split()))
people = [tuple(map(int, read().split())) for _ in range(3)]

min_distance = 1e9
for p in permutations(people):
    distance = sqrt((yumi[0]-p[0][0])**2
                    + (yumi[1]-p[0][1])**2)
    for i in range(2):
        distance += sqrt((p[i][0]-p[i+1][0])**2
                         + (p[i][1]-p[i+1][1])**2)
    
    min_distance = min(min_distance, distance)
    
print(floor(min_distance))
