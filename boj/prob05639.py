# 출처: https://www.acmicpc.net/problem/5639
# 문제: 이진 검색 트리

import sys

sys.setrecursionlimit(100000)
read = sys.stdin.readline


class Node:
    def __init__(self, value, left=None, right=None, parent=None):
        self.value = value
        self.left = left
        self.right = right
        self.parent = parent


def postorder(node):
    if node:
        postorder(node.left)
        postorder(node.right)
        print(node.value)


def make_tree(node_list):
    if len(node_list) < 2:
        return

    if node_list[1].value < node_list[0].value:
        node_list[0].left = node_list[1]
        node_list[1].parent = node_list[0]
    index = 0
    for i, node in enumerate(node_list[1:]):
        if node.value > node_list[0].value:
            node_list[0].right = node
            node.parent = node_list[0]
            index = i
            break
    make_tree(node_list[1 : index + 1])
    make_tree(node_list[index + 1 :])


nodes = []
while True:
    value = read()
    if not value[:-1]:
        break
    nodes.append(Node(int(value)))

make_tree(nodes)
postorder(nodes[0])
