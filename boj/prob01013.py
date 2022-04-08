import re
import sys

read = sys.stdin.readline
regex = re.compile("/(100+1+|01)+/s")

result = []
for _ in range(int(read())):
    result.append("YES" if re.fullmatch(r"(100+1+|01)+", read().rstrip()) else "NO")

print("\n".join(result))
