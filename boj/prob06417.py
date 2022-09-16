import sys


ans = []
for line in sys.stdin.readlines():
    N = int(line)
    if N < 0:
        break
    K = -1
    for i in range(N-1, 1, -1):
        num = N
        for j in range(i-1):
            if (num-1) % i > 0:
                break
            num = (num-1)*(i-1)/i
        else:
            K = i
            break
    ans.append(f"{N} coconuts, " +
               (f"{K} people and 1 monkey" if K > 0 else "no solution"))
print(*ans, sep = "\n")