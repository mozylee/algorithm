import sys


read = sys.stdin.readline

read()
votes = {s: 0 for s in read().split()}

for _ in range(len(votes.keys())):
    for v in read().split():
        votes[v] += 1

print("\n".join(f"{k} {votes[k]}" for k in sorted(votes.keys(), key=lambda x: (-votes[x], x))))
