import sys
read = sys.stdin.readline

T = int(read())
result = []
for _ in range(T):
    inputs = sorted(read().rstrip() for __ in range(int(read())))
    before = inputs[0]
    is_good = True
    for next in inputs[1:]:
        if(next.startswith(before)):
            is_good = False
            break
        before = next
    result.append("YES" if is_good else "NO")
print(*result, sep='\n')
