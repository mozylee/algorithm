import sys


read = sys.stdin.readline


N, M = map(int, read().split())

package, unit = 1e9, 1e9
for _ in range(M):
    p, u = map(int, read().split())
    package = min(package, p)
    unit = min(unit, u)

ret = (N//6) * min(package, 6*unit) + min((N % 6)*unit, package)
print(ret)
