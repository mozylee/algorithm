import re
import sys

read = sys.stdin.readline

print("SUBMARINE" if re.fullmatch(r"(100+1+|01)+", read().rstrip()) else "NOISE")
