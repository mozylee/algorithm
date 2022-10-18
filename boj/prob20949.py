import sys


read = sys.stdin.readline


def parse_monitor(i, W, H):
    return (-(W**2+H**2), i)


monitors = sorted(parse_monitor(i+1, *map(int, read().split()))
                  for i in range(int(read())))

print("\n".join(str(i) for ppi, i in monitors))
