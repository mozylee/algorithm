import sys


read = sys.stdin.readline

S = read().rstrip()

substrings = set()
for i in range(len(S)):
    for j in range(i+1, len(S)+1):
        substrings.add(S[i:j])

print(len(substrings))