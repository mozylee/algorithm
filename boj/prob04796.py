import sys


read = sys.stdin.readline

case = 1
while True:
    L, P, V = map(int, read().split())
    if(sum([L, P, V]) == 0):
        break

    use = (V//P)*L + min(V % P, L)
    print("Case {}: {}".format(case, use))
    case += 1
