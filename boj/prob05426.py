from collections import deque
import sys


read = sys.stdin.readline

sizes = {n**2: n for n in range(1, 101)}

ans = []
for _ in range(int(read())):
    cypher = read().rstrip()
    size = sizes[len(cypher)]
    queue = [deque(cypher[size*i:size*(i+1)]) for i in range(size)]

    plain = []
    for _ in range(size):
        for q in queue:
            plain.append(q.pop())
    
    ans.append("".join(plain))


print(*ans, sep="\n")
