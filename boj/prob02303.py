from itertools import combinations
import sys


read = sys.stdin.readline


def get_score(scores):
    return max(sum(c) % 10 for c in combinations(scores, 3))


N = int(read())

users = [(get_score(map(int, read().split())), i+1) for i in range(N)]

print(max(users)[1])