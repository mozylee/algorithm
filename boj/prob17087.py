import sys
import math

read = sys.stdin.readline
write = sys.stdout.write

_, S = map(int, read().split())

write(math.gcd(*(abs(S - int(a)) for a in read().split())))

# short coding ver
# import math;s=int(input().split()[1]);print(math.gcd(*(s-int(a) for a in input().split())))