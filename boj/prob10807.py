from collections import Counter


N = int(input())
counter = Counter(map(int,input().split()))
print(counter[int(input())])