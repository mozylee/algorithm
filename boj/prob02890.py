import sys


read = sys.stdin.readline

R, C = map(int, read().split())
kayaks = [0]*10
for _ in range(R):
    line = read().rstrip()
    if 'S'+'.'*(C-2)+'F' == line:
        continue

    for i, c in enumerate(line[1:]):
        if c == '.':
            continue

        kayaks[int(c)] = i
        break

scores = {score: rank+1
          for rank, score in enumerate(sorted(set(kayaks[1:]), reverse=True))}

for i in range(1,10):
    print(scores[kayaks[i]])