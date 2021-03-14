# 출처: https://www.acmicpc.net/problem/2250
# 문제: 트리의 높이와 너비


import sys
from collections import defaultdict


class Node:
    def __init__(self, data, left, right) -> None:
        self.parent = -1
        self.data = data
        self.left = left
        self.right = right

    def renew(self, left, right):
        self.left = left
        self.right = right


def inorder(node, level):
    global x
    if tree[node].left != -1:
        inorder(tree[node].left, level + 1)
    levels[level].append(x)
    x += 1
    if tree[node].right != -1:
        inorder(tree[node].right, level + 1)


read = sys.stdin.readline
n = int(read())
x = 1

tree = {i: Node(i, -1, -1) for i in range(1, n + 1)}
for _ in range(n):
    i, left, right = map(int, read().split())
    tree[i].renew(left, right)
    if left != -1:
        tree[left].parent = i
    if right != -1:
        tree[right].parent = i

root = -1
for i in tree.keys():
    if tree[i].parent == -1:
        root = i
        break

levels = defaultdict(list)
inorder(root, 1)
gaps = [(level, max(x) - min(x) + 1) for level, x in levels.items()]
print(*sorted(gaps, key=lambda x: (x[1], -x[0])).pop())

