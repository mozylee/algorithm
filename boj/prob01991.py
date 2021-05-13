# 출처: https://www.acmicpc.net/problem/1991
# 문제: 트리 순회

from sys import stdin


def preorder(node):
    global tree
    if node != ".":
        print(node, end="")
        preorder(tree[node][0])
        preorder(tree[node][1])


def inorder(node):
    global tree
    if node != ".":
        inorder(tree[node][0])
        print(node, end="")
        inorder(tree[node][1])


def postorder(node):
    global tree
    if node != ".":
        postorder(tree[node][0])
        postorder(tree[node][1])
        print(node, end="")


tree = {}
trunks = [
    tuple(stdin.readline().rstrip().split()) for _ in range(int(stdin.readline()))
]
for item, left, right in trunks:
    tree[item] = (left, right)

preorder("A")
print()
inorder("A")
print()
postorder("A")
