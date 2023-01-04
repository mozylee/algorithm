import sys

read = sys.stdin.readline

print(*["="*int(read()) for _ in range(int(read()))], sep="\n")