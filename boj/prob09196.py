import sys


cases = sorted(((i, j) for i in range(1, 150+1)
                for j in range(i+1, 150+2)),
               key=lambda x: (x[0]**2+x[1]**2, x[0]))

read = sys.stdin.readline

ans = []
while(line := read().rstrip()) != "0 0":
    ans.append(cases[cases.index(tuple(map(int, line.split())))+1])

print("\n".join(" ".join(map(str, line)) for line in ans))
