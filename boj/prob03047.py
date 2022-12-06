import sys


read = sys.stdin.readline


indexes = {chr(65+i): i for i in range(3)}

numbers = sorted(map(int, read().split()))
print(*(numbers[indexes[c]] for c in read().rstrip()))