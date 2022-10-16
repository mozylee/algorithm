import sys


read = sys.stdin.readline

ans = []
for _ in range(int(read())):
    votes = sorted(((i+1, int(read()))
                   for i in range(int(read()))), key=lambda x: -x[1])
    total = sum(v for _, v in votes)
    ans.append("no winner" if votes[0][1] == votes[1][1] else (
        "majority" if votes[0][1] > total//2 else "minority")+f" winner {votes[0][0]}")

print(*ans, sep="\n")
