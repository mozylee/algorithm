import sys


read = sys.stdin.readline

MBTI = read().rstrip()

print(sum(1 if read().rstrip() == MBTI else 0 for _ in range(int(read()))))
