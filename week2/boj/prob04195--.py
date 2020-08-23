# Backjoon Online Judge: https://www.acmicpc.net/problem/4195
# 문제: 친구 네트워크

# 민혁이는 소셜 네트워크 사이트에서 친구를 만드는 것을 좋아하는 친구이다.
# 우표를 모으는 취미가 있듯이, 민혁이는 소셜 네트워크 사이트에서 친구를 모으는 것이 취미이다.
# 어떤 사이트의 친구 관계가 생긴 순서대로 주어졌을 때, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.
# 친구 네트워크란 친구 관계만으로 이동할 수 있는 사이를 말한다.

# 문제 이해도 제대로 못한듯;


import sys
from collections import deque

inputs = deque(sys.stdin.readlines())
inputs.popleft()

while len(inputs) > 0:
    m = int(inputs.popleft())
    names = {}
    for i in range(m):
        name1, name2 = inputs.popleft().split()
        if name1 in names:
            names[name1] += 1
        else:
            names[name1] = 1
        if name2 in names:
            names[name2] += 1
        else:
            names[name2] = 1
        sys.stdout.write(str(names[name1] + names[name2]) + '\n')
