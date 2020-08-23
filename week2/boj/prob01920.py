# Backjoon Online Judge: https://www.acmicpc.net/problem/1920
# 문제: 수 찾기

# N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.


import sys

n = sys.stdin.readline()
array = list(map(int, sys.stdin.readline().split()))
m = sys.stdin.readline()
check = list(map(int, sys.stdin.readline().split()))
array.sort()


def binary_search(n):
    global array
    left, right = 0, len(array) - 1
    while left <= right:
        mid = (left + right) // 2
        if n > array[mid]:
            left = mid + 1
        elif n < array[mid]:
            right = mid - 1
        else:
            return '1\n'
    return '0\n'


for i in check:
    if i > array[-1] or i < array[0]:
        sys.stdout.write('0\n')
    else:
        sys.stdout.write(binary_search(i))
