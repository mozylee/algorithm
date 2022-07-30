import sys


def read_and_parse(): return tuple(map(int, sys.stdin.readline().split()))


t1, v1 = read_and_parse()
t2, v2 = read_and_parse()

if t2<0 and v2>=10:
    print("A storm warning for tomorrow! Be careful and stay home if possible!")
elif t2<t1:
    print("MCHS warns! Low temperature is expected tomorrow.")
elif v2>v1:
    print("MCHS warns! Strong wind is expected tomorrow.")
else:
    print("No message")
