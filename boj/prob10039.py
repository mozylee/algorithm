# Backjoon Online Judge: https://www.acmicpc.net/problem/10039
# 내용없음

scores = []
for i in range(5):
    scores.append(int(input()))

print(sum([score if score >= 40 else 40 for score in scores]) // len(scores))
