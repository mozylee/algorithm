import sys

for line in sys.stdin.readlines():
    s = list(map(int, line.split()))
    n, s = s[0], s[1:]
    jollyable = sorted(abs(s[i]-s[i+1]) for i in range(n-1))
    flag = True
    for i, j in enumerate(jollyable):
        if i+1 != j:
            flag = False
            break
    print("Jolly" if flag else "Not jolly")
