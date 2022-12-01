import sys


read = sys.stdin.readline


alphabet = {chr(i): i for i in range(65, 91)}

total_points = sum(alphabet.values())

ans = []
for _ in range(int(read())):
    ans.append(total_points-sum(alphabet[s] for s in set(read().rstrip())))

print(*ans, sep="\n")
