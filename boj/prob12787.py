import sys


read = sys.stdin.readline


def parse_ip_to_int(ip):
    return int("".join(bin(int(x))[2:].zfill(8) for x in ip.split(".")), base=2)


def parse_int_to_ip(num):
    bins = []
    for _ in range(8):
        bins.append(num % 256)
        num //= 256
    return ".".join(map(str, bins[::-1]))


ans = []
for _ in range(int(read())):
    M, N = read().rstrip().split()

    ans.append(parse_ip_to_int(N) if M == '1' else parse_int_to_ip(int(N)))

print(*ans, sep="\n")
